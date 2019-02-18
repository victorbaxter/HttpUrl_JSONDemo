package com.example.kiz.httpurl_jsondemo;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpAsyncTask extends AsyncTask<Void, Void, List<Repo>> {

    private IAsyncResponse asyncResponse;

    public HttpAsyncTask(IAsyncResponse asyncResponse) {
        this.asyncResponse = asyncResponse;
    }

    @Override
    protected List<Repo> doInBackground(Void... voids) {
        return getData();
    }
    @Override
    protected void onPostExecute(List<Repo> repos) {
      asyncResponse.processFinish(repos);
    }

    private List<Repo> getData() {
        InputStream inputStream = null;
        String result = "";
        try {
            URL url = new URL("https://api.github.com/users/google/repos");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            inputStream = new BufferedInputStream(urlConnection.getInputStream());
            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                Log.e("InputStream", "Did not work!");
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
        }
        return readJSON(result);
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;
        inputStream.close();
        return result;
    }

    private List<Repo> readJSON(String result) {
        List<Repo> repos = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String id = jsonObject.getString("id");
                String nodeId = jsonObject.getString("node_id");
                String name = jsonObject.getString("name");
                String isPrivate = jsonObject.getString("private");
                String ownerId = jsonObject.getJSONObject("owner").getString("id");
                String html_url = jsonObject.getString("html_url");
                String description = jsonObject.getString("description");
                Log.d("data", id);
                Repo repo = new Repo(id, nodeId, name, isPrivate, ownerId, html_url, description);
                repos.add(repo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return repos;
    }
}
