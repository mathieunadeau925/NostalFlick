<!DOCTYPE html>
<html>
    <head>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <fmt:setLocale value=
                       "${not empty sessionScope.langue ? sessionScope.langue : pageContext.request.locale}"
                       ></fmt:setLocale>
        <fmt:setBundle basename="i18n/app"/>
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
                                    <fmt:message key="ErrorPagePar"></fmt:message>
                                    </h2>
                                    <a class="is-medium" href="ControleListe?action=accueil"><fmt:message key="ErrorPageLink"></fmt:message></a>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
            <br />

        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>