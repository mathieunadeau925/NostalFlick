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
        <!-- Premiere colonne -->
        <br>
        <c:if test="${clientDelete}">
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <div class="column">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                        <fmt:message key="ModifClientDelete"></fmt:message>
                                        </h2>
                                    </div>
                                </section>
                                <br>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
        </c:if>

        <c:if test="${echecDelete}">
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <div class="column">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                        <fmt:message key="ModifProduitError"></fmt:message>
                                        </h2>
                                    </div>
                                </section>
                                <br>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
        </c:if>
        <div class="container">
            <div class="block">
                <div class="columns">
                    <div class="column">
                        <form name="formSearch" method="post" action="ControleEmpListeClients?action=rechercheClient">
                            <div class="field has-addons has-addons-centered">
                                <div class="control">
                                    <input class="input is-dark is-medium is-expanded" type="text" name="txtRecherche" placeholder="<fmt:message key="ModifClientSearch"></fmt:message>">
                                    </div>
                                    <div class="control">
                                        <input class="button is-black is-medium" name="btnEnvoyer" type="submit" value="<fmt:message key="ClientSearchBtnSubmit"></fmt:message>">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <br>
                    </div>
                </div>
            </div>
        <c:if test="${rechercheClient}">
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <c:if test="${listeClients.size() <= 0}">
                            <div class="column">
                                <section class="hero is-light">
                                    <div class="hero-body">
                                        <h2 class="subtitle">
                                            <fmt:message key="ModifClientEmpty"></fmt:message>
                                            </h2>
                                        </div>
                                    </section>
                                </div>
                        </c:if>
                        <c:if test="${listeClients.size() > 0}">
                            <table class="table has-background-dark is-fullwidth">
                                <thead>
                                    <tr>
                                        <th class="title has-text-centered has-text-white">
                                            <fmt:message key="ModifClientNum"></fmt:message>
                                            </th>
                                            <th class="title has-text-centered has-text-white">
                                            <fmt:message key="AccountCreationAdminName"></fmt:message>
                                            </th>
                                            <th class="title has-text-centered has-text-white">
                                            <fmt:message key="AccountCreationAdminFName"></fmt:message>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="client" items="${listeClients}">
                                        <tr>
                                            <td class="has-text-centered subtitle has-text-white">
                                                <span>${client.numero}</span>
                                            </td>
                                            <td class="has-text-centered subtitle has-text-white">
                                                <span>${client.nom}</span>
                                            </td>
                                            <td class="has-text-centered subtitle has-text-white">
                                                <span>${client.prenom}</span>
                                                <a href="ControleEmpListeClients?action=modifier&noClient=${client.numero}" class="button is-danger is-pulled-right is-medium"><fmt:message key="EmpModifyProduct"></fmt:message></a>
                                                </td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:if>


        <c:if test="${!rechercheClient}">
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <c:if test="${listeClients.size() <= 0}">
                            <div class="column">
                                <section class="hero is-light">
                                    <div class="hero-body">
                                        <h2 class="subtitle">
                                            <fmt:message key="ModifClientEmpty"></fmt:message>
                                            </h2>
                                        </div>
                                    </section>
                                </div>
                        </c:if>
                        <c:if test="${listeClients.size() > 0}">
                            <table class="table has-background-dark is-fullwidth">
                                <thead>
                                    <tr>
                                        <th class="title has-text-centered has-text-white">
                                            <fmt:message key="ModifClientNum"></fmt:message>
                                            </th>
                                            <th class="title has-text-centered has-text-white">
                                            <fmt:message key="AccountCreationAdminName"></fmt:message>
                                            </th>
                                            <th class="title has-text-centered has-text-white">
                                            <fmt:message key="AccountCreationAdminFName"></fmt:message>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="client" items="${listeClients}" >
                                        <tr>
                                            <td class="has-text-centered subtitle has-text-white">
                                                <span>${client.numero}</span>
                                            </td>
                                            <td class="has-text-centered subtitle has-text-white">
                                                <span>${client.nom}</span>
                                            </td>
                                            <td class="has-text-centered subtitle has-text-white">
                                                <span>${client.prenom}</span>
                                                <a href="ControleEmpListeClients?action=modifier&noClient=${client.numero}" class="button is-danger is-pulled-right is-medium"><fmt:message key="EmpModifyProduct"></fmt:message></a>
                                                </td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:if>
        <br>
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
