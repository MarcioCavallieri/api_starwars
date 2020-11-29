package com.starwars.recursos;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class SwapiApiRecurso {
	private static final String HOST = "https://swapi.dev";
	private static final String MOUNT_POINT_PLANETAS = "/api/planets";

	public static Integer obterTotalDeFilmes(String nomeDoPlaneta) {
		HttpResponse<String> response = Unirest.get(HOST + MOUNT_POINT_PLANETAS + "/?search=" + nomeDoPlaneta)
				.asString();
		JSONObject resposta = new JSONObject(response.getBody().toString());
		JSONArray results = resposta.getJSONArray("results");

		if (results == null || results.length() == 0) {
			return 0;
		}
		
		JSONArray films = results.getJSONObject(0).getJSONArray("films");
		
		if (films == null) {
			return 0;
		}
		
		return films.length();
	}
}
