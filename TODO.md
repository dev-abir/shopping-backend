# TODOS:
1. Use a *'real'* database.
2. Add testing(may use JUnit, but as it is a REST API, I would like to use use selenium, or a JAVA alternative of selenium)
3. Spark has some serious problems([see this](https://github.com/dev-moss/shopping-backend/blob/42180f4d1a83b437c6ca0539d0a9e190a2c855d1/src/main/java/application/Main.java#L30))
it has another problem, there is no way(I have tried to find a solution for it in the internet) to send a *secure*(I mean secure flag is true) JSESSIONID to the client's browser, when the communication is over a SSL.
[see this](https://stackoverflow.com/questions/3038223/how-to-get-jetty-to-send-jsessionid-cookies-with-the-secure-flag-when-using-a-se), I cannot use this solution as sparkjava doesn't have a 'WEB-INF' thing,
maybe I need to configure the embedded Jetty to use a WEB-INF, or just use a secure JSESSIONID
Someone has found a workaround, i.e., to create a custom cookie rather than to use JSESSIONID([see this](https://github.com/jeckep/simple-sparkjava-redis-session-manager/blob/be68d017e5708c7ece4ca7d624a6d5565822401e/src/main/java/com/github/jeckep/spark/PSF.java#L18))
3. Use something else rather than sparkjava(like jersey, javelin or the best Spring boot)
