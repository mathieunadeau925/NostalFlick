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
        <%@include file="../jspf/headerEmploye.jspf" %>
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
                        <c:if test="${carteAjoutee}">
                            <h1 class="title has-text-white" >
                                <fmt:message key="CardSaved"></fmt:message>
                                </h1>
                        </c:if>
                        <br>
                        <a class="button is-black has-text-white is-medium" href="ControleEmpCarte?action=formCarte"><fmt:message key="ListCardsAddCard"></fmt:message></a>
                            <br>
                            <br>
                            <table class="table has-background-white is-fullwidth">
                                <thead>
                                    <tr>
                                        <th class="has-text-left subtitle has-text-dark"><fmt:message key="BuyPageCc"></fmt:message></th>
                                        <th class="has-text-left subtitle has-text-dark"><fmt:message key="BuyPageCardType"></fmt:message></th>
                                        <th class="has-text-right subtitle has-text-dark"><fmt:message key="BuyPageExpDate"></fmt:message></th>
                                        <th class="has-text-right subtitle has-text-dark"><fmt:message key="BuyPageSecurityCode"></fmt:message></th>
                                        <th class="has-text-right subtitle has-text-dark"><fmt:message key="ListCardsClientNo"></fmt:message></th>
                                        <th class="has-text-right subtitle has-text-dark"><fmt:message key="BuyPageFName"></fmt:message></th>
                                        <th class="has-text-right subtitle has-text-dark"><fmt:message key="BuyPageName"></fmt:message></th>
                                    </tr>
                                </thead>
                            <c:forEach var="carte" items="${listeCartes}">
                                <tr>
                                    <td class="has-text-left subtitle has-text-dark">
                                        <span>${carte.carteCredit}</span>
                                    </td>
                                    <td class="has-text-left subtitle has-text-dark">
                                        <span>${carte.typeCarte}</span>
                                    </td>
                                    <td class="has-text-right subtitle has-text-dark">
                                        <span>${carte.date}</span>
                                    </td>
                                    <td class="has-text-right subtitle has-text-dark">
                                        <span>${carte.numVerif}</span>
                                    </td>
                                    <td class="has-text-right subtitle has-text-dark">
                                        <span>${carte.noClient}</span>
                                    </td>
                                    <td class="has-text-right subtitle has-text-dark">
                                        <span>${carte.prenom}</span>
                                    </td>
                                    <td class="has-text-right subtitle has-text-dark">
                                        <span>${carte.nom}</span>
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