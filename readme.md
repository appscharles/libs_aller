# Java library for REST API Polish Allegro.pl

Simple service:
```
RestManagerConfiguration configuration = RestManagerConfigurationBuilder
        .create(true, "{{client_id}}", "{{client_secret}}", 11001, "salt", new File("tokens.data")).build();

String sellerId = RestManager.getSellerId("{{login_allegro}}");
ListingResponse response = OffersListingRest.get(sellerId,"{{login_allegro}}");
```

Register your application in Allegro.pl, with localhost redirect url, example `http://localhost:11001`.

More methods rest in package `com.appscharles.libs.aller.rests`.

# Include library to project by gradle

```
repositories {
    maven {
        url 'http://dl.bintray.com/appscharles/libs'
    }
}
```

Add dependency:
```
compile group: 'com.appscharles.libs', name: 'aller', version: '1.0.0+'
```

# File properties for tests

File properties placed in localization `~/appscharles/libs/aller/properties.properties`.

```
libs_aller.test.client_id =
libs_aller.test.client_secret =
libs_aller.test.login_allegro =
libs_aller.test.password_allegro =
```