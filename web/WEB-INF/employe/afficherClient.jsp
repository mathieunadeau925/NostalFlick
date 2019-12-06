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

        <div class="container">
            <div class="block">
                <div class="columns">
                    <div class="column">
                        <c:if test="${cpErreur}">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                        <fmt:message key="AccountPageErrorPc"></fmt:message>
                                        </h2>
                                    </div>
                                </section>
                        </c:if>
                        <c:if test="${ccErreur}">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                        <fmt:message key="AccountPageErrorCc"></fmt:message>
                                        </h2>
                                    </div>
                                </section>
                        </c:if>
                        <c:if test="${reussite}">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                        <fmt:message key="EmpUpdateSuccess"></fmt:message>
                                        </h2>
                                    </div>
                                </section>
                        </c:if>
                        <div class="content">
                            <br>
                            <form name="formClient" method="post" action="ControleEmpClient?action=update">
                                <table class="table has-background-light">
                                    <thead>
                                        <tr>
                                            <th colspan="2">
                                                <p><fmt:message key="AccountTableHeader"></fmt:message></p>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="ModifClientNum"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="noClient" value="${requestScope.client.numero}" readonly>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageName"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="nom" value="${requestScope.client.nom}">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageFName"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="prenom" value="${requestScope.client.prenom}">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageAddress"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="adresse" value="${requestScope.client.adresse}">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageCity"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="ville" value="${requestScope.client.ville}">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPagePc"></fmt:message>(A0A0A0)
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="codePostal" pattern="[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]"
                                                           value="${requestScope.client.codePostal}"> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><p class="subtitle has-text-left"><fmt:message key="BuyPageCc"></fmt:message></p></td>
                                                <td>
                                                    <input class="input" type="text" name="carteCredit" pattern="[0-9]{16}" value="${requestScope.client.carteCredit}">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><p class="subtitle has-text-left"><fmt:message key="ConnectionPasswordField"></fmt:message></p></td>
                                                <td>
                                                    <input class="input" type="text" name="mdp" value="${requestScope.client.mdp}">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="has-addons">
                                    <a class="button has-text-centered is-pulled-left is-danger is-medium" href="ControleEmpClient?action=supprimerClient&noClient=${client.numero}"><fmt:message key="DeleteClientButton"></fmt:message></a>
                                    <input class="button is-black has-text-centered is-pulled-right has-text-white is-medium" type="submit" value="<fmt:message key="ModifyClientButton"></fmt:message>">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
