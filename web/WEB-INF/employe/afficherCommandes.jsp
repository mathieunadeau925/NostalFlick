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
                        <c:if test="${vide}">
                            <h1 class="title has-text-light">
                                <fmt:message key="OrdersEmptyList"></fmt:message>
                                </h1>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="block">
                <div class="columns">
                    <div class="column">
                        <h1 class="title"><fmt:message key="OrdersSelectHeader"></fmt:message></h1>
                            <form name="selectForm" action="ControleEmpListeCommandes?action=filter" method="post">
                                <div class="field has-addons has-addons-centered">
                                    <div class="control">
                                        <div class="select is-info is-medium">

                                            <select name="selectPersonne">
                                                <option value="0"><fmt:message key="OrdersSelectOption"></fmt:message></option>
                                            <c:forEach var="personne" items="${listeClients}" >
                                                <option value="${personne.numero}">${personne.nom} , ${personne.prenom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="control">
                                    <input class="button is-black is-medium" name="btnEnvoyer" type="submit" value="<fmt:message key="OrderSearchBtnSubmit"></fmt:message>">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <div class="column">
                            <br>
                            <br>
                            <table class="table has-background-white is-fullwidth">
                                <thead>
                                    <tr>
                                        <th class="has-text-centered subtitle has-text-dark"><fmt:message key="OrderNumber"></fmt:message></th>
                                    <th class="has-text-centered subtitle has-text-dark"><fmt:message key="ProductNo"></fmt:message></th>
                                    <th class="has-text-centered subtitle has-text-dark"><fmt:message key="MovieName"></fmt:message></th>
                                    <th class="has-text-centered subtitle has-text-dark"><fmt:message key="OrderCustomerName"></fmt:message></th>
                                    <th class="has-text-centered subtitle has-text-dark"><fmt:message key="OrderCustomerFirstName"></fmt:message></th>
                                    <th class="has-text-centered subtitle has-text-dark"><fmt:message key="MovieQuantity"></fmt:message></th>
                                    <th colspan="2" class="has-text-centered subtitle has-text-dark"><fmt:message key="OrderDate"></fmt:message></th>
                                    <th class="has-text-right subtitle has-text-dark"><fmt:message key="OrderPrice"></fmt:message></th>
                                    </tr>
                                </thead>
                            <c:forEach var="commande" items="${listeCommandes}">
                                <tr>
                                    <td class="has-text-left subtitle has-text-dark">
                                        <span>${commande.noCommande}</span>
                                    </td>
                                    <td class="has-text-left subtitle has-text-dark">
                                        <span>${commande.noProduit}</span>
                                    </td>
                                    <td class="has-text-centered subtitle has-text-dark">
                                        <span>${commande.nomProduit}</span>
                                    </td>
                                    <td class="has-text-centered subtitle has-text-dark">
                                        <span>${commande.nomClient}</span>
                                    </td>
                                    <td class="has-text-centered subtitle has-text-dark">
                                        <span>${commande.prenomClient}</span>
                                    </td>
                                    <td class="has-text-centered subtitle has-text-dark">
                                        <span>${commande.quantite}</span>
                                    </td>
                                    <td colspan="2" class="has-text-centered subtitle has-text-dark">
                                        <span>${commande.dateCommande}</span>
                                    </td>
                                    <td class="has-text-right subtitle has-text-dark">
                                        <span>${commande.prixCommande}</span>
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