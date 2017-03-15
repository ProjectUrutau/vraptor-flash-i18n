# Vraptor flash i18n

Write your i18n messages with a fluent and easy mode in Vraptor.

The common way to add a message(without translate) into vraptor is:

```java 
  result.include("mensagem", "Vraptor é incrível").redirectTo(this).method();
```

There is some ways to translate this. Basically what this pluggin makes is facilitate within standardized way of internationalize your messages, throught the method chain we could use just:

```java 
  flash.use("success").toShow("vraptor_awesome").redirectTo(this).method();
```

You could use the Validator object too, using flashError object like:

```java 
  // "error" is one category
  flashError.validate("error");
  // Bellow we can put many errors
  flashError.add("vraptor_awesome").onErrorRedirectTo(this).method();
  ...
```

## Configure your i18n

This pluggin works with I18nMessage native Vraptor class. So to create a language support, you should put into (WEB-INF/classes) or (src/main/resources/) files like:

messages.properties<br/>
messages_en_US.properties

Each with the logic:
```text 
# key = translated_message
vraptor_awesome = Vraptor is awesome!
``` 

### Install

Add into your pom.xml:
```xml 
		<dependency>
			<groupId>io.github.projecturutau</groupId>
			<artifactId>vraptor-flash-i18n</artifactId>
			<version>0.01</version>
		</dependency>
```

<i>Veja também:</i>

http://www.vraptor.org/pt/docs/guia-de-10-minutos/#arquivo-de-mensagens<br/>
http://blog.caelum.com.br/i18n-internacionalizacao-com-jstl/

