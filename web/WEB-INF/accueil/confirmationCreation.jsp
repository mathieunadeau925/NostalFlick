<!DOCTYPE html>
<html>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value=
                   "${not empty sessionScope.langue ? sessionScope.langue : pageContext.request.locale}"
                   ></fmt:setLocale>
    <fmt:setBundle basename="i18n/app"/>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <link rel="stylesheet" type="text/css" href="css/bulma.css"/>
        <title><fmt:message key="HeadTitle"></fmt:message></title>
        </head>
        <body class="has-text-centered has-background-dark">
            <div class="container-fluid">
                <div class="block">
                    <div class="columns">
                        <div class="column is-12">
                            <figure class="image">
                                <img class ="is-rounded" src="./images/dsc9113-16-9.1280x240.jpg" id="imgBarre" alt="" />
                                <hr>
                            </figure>

                            <h1 class="title has-text-light">
                            <fmt:message key="WelcomeHeader"></fmt:message>
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <div class="column">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                    <fmt:message key="AccountCreationConfMess"></fmt:message>
                                    </h2>
                                    <div class="has-text-centered">
                                        <a class="button is-dark is-large" href="ControleListe?action=client"><fmt:message key="CustomerLinkText"></fmt:message></a>
                                    <a class="button is-dark is-large" href="ControleListe?action=employe"><fmt:message key="AdminLinkText"></fmt:message></a>
                                        <br>
                                    </div>
                                </div>

                            </section>
                            <br>
                            <br>
                            <a class="button is-text has-text-grey-light is-medium" href="ControleListe?action=nouveauClient"><fmt:message key="NewAccountLinkText"></fmt:message></a>
                        </div>
                    </div>
                </div>
            </div>
            <br />
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>