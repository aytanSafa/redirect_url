# Redirect URL

The url redirection application redirects to the real url address when it comes with a shortcode. If we give an example from Twitter, we see that a redirect is made to the twitter address with the t.co short code.We have achieved this in this application.

## Installation

Dockerfile is available in the project. If you enter the necessary docker commands below, the application will stand up.


```bash
docker build --build-arg JAR_FILE=target/*.jar -t aytan/redirect .
docker run -p 8080:8080 aytan/redirect
```


## Usage

If you want to do url redirect, first you need to send tokens. You can then call the url redirect endpoint.The goal here is to add a layer of security to the application.

There are two short_codes defined for the application.

t.co and bit.ly

These two shortcodes are automatically saved in the h2 database when the application starts.

There is a postman JSON collection in the repository. You can try importing APIs in Postman and see the redirection.




