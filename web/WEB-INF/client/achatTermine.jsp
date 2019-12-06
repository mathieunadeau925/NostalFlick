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
        <%@include file="../jspf/headerClient.jspf" %>
        <div class="container-fluid">
            <div class="block">
                <div class="columns">
                    <div class="column is-12">
                        <h1 class="title has-text-light">
                            <fmt:message key="HeadTitle"></fmt:message>
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
                                    <fmt:message key="ThankYouMessage"></fmt:message> ${sessionScope.client.prenom}!
                                    </h2>
                                </div>
                                <a class="is-medium" href="ControleDeconnexion"><fmt:message key="ThankYouDisconnect"></fmt:message></a>
                            </section>
                            <br>
                            <br>
                            <table class="table has-background-black is-fullwidth">
                                <thead>
                                    <tr>
                                        <th class="has-text-left subtitle has-text-white"><fmt:message key="BuyPageName"></fmt:message>, <fmt:message key="BuyPageFName"></fmt:message></th>
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="BuyPageAddress"></fmt:message></th>
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="BuyPageCity"></fmt:message></th>
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="BuyPagePc"></fmt:message></th>      
                                    </tr>
                                </thead>
                                <tr>
                                    <td class="has-text-left subtitle has-text-white">${sessionScope.client.nom},${sessionScope.client.prenom}</td>
                                <td class="has-text-left subtitle has-text-white">${sessionScope.client.adresse}</td>
                                <td class="has-text-left subtitle has-text-white">${sessionScope.client.ville}</td>
                                <td class="has-text-left subtitle has-text-white">${sessionScope.client.codePostal}</td>      
                            </tr>
                        </table>
                        <table class="table has-background-black is-fullwidth">
                            <thead>
                                <tr>
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="ProductNo"></fmt:message></th>
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="MovieName"></fmt:message></th>
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="MovieQuantity"></fmt:message></th>
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="OrderDate"></fmt:message></th>      
                                    <th class="has-text-left subtitle has-text-white"><fmt:message key="OrderPrice"></fmt:message></th>   
                                    </tr>
                                </thead>
                            <c:forEach var="commande" items="${commandes}">

                                <tr>
                                    <td class="has-text-left subtitle has-text-white">
                                        <span>${commande.noProduit}</span>
                                    </td>
                                    <td class="has-text-left subtitle has-text-white">
                                        <span>${commande.nomProduit}</span>
                                    </td>
                                    <td class="has-text-left subtitle has-text-white">
                                        <span>${commande.quantite}</span>
                                    </td>
                                    <td class="has-text-left subtitle has-text-white">
                                        <span>${commande.dateCommande}</span>
                                    </td>
                                    <td class="has-text-left subtitle has-text-white">
                                        <span>${commande.prixCommande} $</span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <br />

        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>