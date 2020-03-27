package utils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import user.User;

public class OAuthVerifier {

	public static final String CLIENT_ID = "1013510210228-dlqcm23qbkjhphrb0t5utr0c4eru9jar.apps.googleusercontent.com";

	public User verify(String idTokenString) throws Exception {
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
				JacksonFactory.getDefaultInstance()).setAudience(Collections.singletonList(CLIENT_ID)).build();

		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(idTokenString);
		} catch (GeneralSecurityException | IOException e) {
			System.err.println("[ERROR] Internal server error!");
			e.printStackTrace();
			throw new Exception("Internal server error!");
		}
		if (idToken != null) {
			Payload payload = idToken.getPayload();

			boolean mailVerified = Boolean.valueOf(payload.getEmailVerified()); // TODO : Is it required?
			String name = (String) payload.get("name");
			String mailID = payload.getEmail();
			return new User(name, mailID, mailVerified);

			/*
			 * // Print user identifier String userId = payload.getSubject();
			 * System.out.println("User ID: " + userId);
			 * 
			 * // Get profile information from payload String email = payload.getEmail();
			 * boolean emailVerified = Boolean.valueOf(payload.getEmailVerified()); String
			 * name = (String) payload.get("name"); String pictureUrl = (String)
			 * payload.get("picture"); String locale = (String) payload.get("locale");
			 * String familyName = (String) payload.get("family_name"); String givenName =
			 * (String) payload.get("given_name");
			 */
		} else {
			return null;
		}
	}
}