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
        <div class="container">
            <div class="block">
                <div class="columns">
                    <div class="column">
                        <div class="content">
                            <c:if test="${sessionScope.panier.size() <= 0}">
                                <h1 class="title has-text-white" >
                                    <fmt:message key="EmptyCartText"></fmt:message>
                                    </h1>
                            </c:if>
                            <c:if test="${sessionScope.panier.size() > 0}">
                                <table class="table has-background-dark">
                                    <thead>
                                        <tr>
                                            <th colspan="2" class="title has-text-centered has-text-white">
                                                <fmt:message key="CartHeadMessage"></fmt:message>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="produit" items="${sessionScope.panier}">
                                            <tr>
                                                <td class="has-text-left subtitle has-text-white">
                                                    <span>${produit.nomProduit}</span>
                                                </td>
                                                <td class="has-text-right subtitle has-text-white">
                                                    <span>${produit.prixProduit}  $</span>
                                                    <a href="ControlePanier?action=delete&produitNo=${produit.noProduit}" class="delete is-pulled-right is-medium"></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <table class="table is-bordered is-narrow has-background-dark is-pulled-right">
                                    <thead>
                                        <tr>
                                            <th>
                                                <p class="has-text-white subtitle has-text-left"><fmt:message key="CartPrice"></fmt:message></p>
                                                </th>
                                                <th>
                                                    <p class="has-text-white subtitle has-text-right">${sessionScope.prixTotal} $</p>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <p class="has-text-white subtitle has-text-left"><fmt:message key="CartPriceTps"></fmt:message></p>
                                                </th>
                                                <th>
                                                    <p class="has-text-white subtitle has-text-right">${sessionScope.prixTps} $</p>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <p class="has-text-white subtitle has-text-left"><fmt:message key="CartPriceTvq"></fmt:message></p>
                                                </th>
                                                <th>
                                                    <p class="has-text-white subtitle has-text-right">${sessionScope.prixTvq} $</p>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <p class="has-text-white subtitle has-text-left"><fmt:message key="CartPriceTotal"></fmt:message></p>
                                                </th>
                                                <th>
                                                    <p class="has-text-white subtitle has-text-right">${sessionScope.prixTotalAvecTaxes} $</p>
                                            </th>
                                        </tr>
                                    </thead>
                                </table>
                                <a class="button is-danger is-pulled-left" href="ControlePanier?action=deleteAll"><fmt:message key="EmptyCartButton"></fmt:message></a>
                                <a class="button is-black is-pulled-right" href="ControlePanier?action=buy"><fmt:message key="BuyCartButton"></fmt:message></a>
                            </c:if>
                        </div>
                    </div>
                </div>
                <br>
            </div>
        </div>
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
