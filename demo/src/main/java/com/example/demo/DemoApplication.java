package com.example.demo;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.config.ElasticConfig;
import com.fasterxml.jackson.databind.*;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.RestStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

			//System.out.println("Open connection");
			/*ElasticConfig config = new ElasticConfig();
			Client client = config.client();*/

			/*String json = "{" +
			        "\"user\":\"kimchy\"," +
			        "\"postDate\":\"2013-01-30\"," +
			        "\"message\":\"trying out Elasticsearch\"" +
			    "}"; */ //düz json yapısı

			/*Map<String, Object> json = new HashMap<String, Object>(); // mapli json yapısı.
			json.put("user","kimchy");
			json.put("postDate",new Date());
			json.put("message","trying out Elasticsearch");*/

			/*
			// instance a json mapper
			ObjectMapper mapper = new ObjectMapper(); // create once, reuse

			// generate json
			byte[] json = mapper.writeValueAsBytes(yourbeaninstance);*/



			/*
			XContentBuilder builder = jsonBuilder()
			    .startObject()
			        .field("user", "kimchy")
			        .field("postDate", new Date())
			        .field("message", "trying out Elasticsearch")
			    .endObject()

			     String json = builder.string();*/


			/*ElasticConfig config = new ElasticConfig();
			Client client = config.client()	;
			System.out.println("Connection is opened");
			GetResponse response = client.prepareGet("customer", "external", "1").get();
			System.out.println(response.getSourceAsString());
			System.out.println(response.getIndex());
			System.out.println(response.getType());
			System.out.println(response.getId());
			System.out.println(response.getField("name"));*/

			/*try {
				IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
				        .setSource(jsonBuilder()
				                    .startObject()
				                        .field("user", "kimchy")
				                        .field("postDate", new Date())
				                        .field("message", "trying out Elasticsearch")
				                    .endObject()
				                  )
				        .get();

				// Index name
				String _index = response.getIndex();
				// Type name
				String _type = response.getType();
				// Document ID (generated or not)
				String _id = response.getId();
				// Version (if it's the first time you index this document, you will get: 1)
				long _version = response.getVersion();
				// status has stored current instance statement.
			//	RestStatus status = response.status();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			/* Idsiz belge indeksleme
			 String json = "{" +
        "\"user\":\"kimchy\"," +
        "\"postDate\":\"2013-01-30\"," +
        "\"message\":\"trying out Elasticsearch\"" +
    "}";

IndexResponse response = client.prepareIndex("twitter", "tweet")
        .setSource(json)
        .get();
			 */

			/*System.out.println("Close the connection");
			client.close();
			System.out.println("Connection is closed");*/

		SpringApplication.run(DemoApplication.class, args);
	}
}
