# Vraptor flash i18n

Write your i18n messages with a fluent and easy mode in Vraptor.

The common way to add a message(without translate) into vraptor is:

```java 
  result.include("mensagem", "Vraptor é incrível").redirectTo(this).method();
```

There is some ways to translate this. Basically what this pluggin makes is facilitate within standardized way of internationalize your messages, throught the method chain we could use just:

```java 
  flash.use("message").toShow("vraptor_awesome").redirectingTo(this).method();
```

You could use a conditional method to evaluates if a message should be showed up:

```java 
  flash.when(true).use("message").toShow("vraptor_awesome").redirectingTo(this).method();
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

Veja também:

http://www.vraptor.org/pt/docs/guia-de-10-minutos/#arquivo-de-mensagens
http://blog.caelum.com.br/i18n-internacionalizacao-com-jstl/

