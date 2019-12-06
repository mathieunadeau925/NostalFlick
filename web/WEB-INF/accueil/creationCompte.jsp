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
                            <c:if test="${erreur}">
                                <fmt:message key="AccountCreationErrMsg"></fmt:message>
                            </c:if>
                            <c:if test="${!erreur}">
                                <fmt:message key="WelcomeHeader"></fmt:message>
                            </c:if>
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="block"> 
                <div class="columns is-centered">
                    <div class="column is-narrow">
                        <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                            <thead>
                                <tr>
                                    <th colspan="4">
                                        <div class="is-size-2 has-text-centered"><fmt:message key="AccountCreationMessage"></fmt:message></div>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2"><p class="subtitle has-text-right"><fmt:message key="AccountCreationUser"></fmt:message></p></td>
                                        <td colspan="2">
                                            <input type="radio" name="userType" value="admin" id="radioAdmin" onclick="compteAdmin()">
                                        <fmt:message key="AccountCreationAdmin"></fmt:message>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <input type="radio" name="userType" value="client" checked="checked" id="radioClient"  onclick="compteClient()">
                                        <fmt:message key="AccountCreationClient"></fmt:message>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="columns is-centered">
                        <div class="column is-narrow">
                            <form name="formAdmin" method="post" action="ControleCreation?action=admin">
                                <table  id="compteAdmin" class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth is-hidden">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <p class="subtitle has-text-right">
                                                <fmt:message key="AccountCreationAdminName"></fmt:message>
                                                </p>
                                            </td>
                                            <td colspan="4"><input  class="input is-small" type="text" name="nom"></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <p class="subtitle has-text-right">
                                                <fmt:message key="AccountCreationAdminFName"></fmt:message>
                                                </p>
                                            </td>
                                            <td colspan="4"><input  class="input is-small" type="text" name="prenom"></td>
                                        </tr>
                                        <tr>
                                            <td><p class="subtitle has-text-right"><fmt:message key="AccountCreationPwd"></fmt:message></p></td>
                                            <td colspan="4"><input class="input is-small" type="text" name="mdp"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><p class="has-text-centered">
                                                    <input class="button is-dark" type="submit" name="btnCreation" value="<fmt:message key="AccountCreationButtonValue"></fmt:message>">
                                                </p></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                        <form name="formClient" method="post" action="ControleCreation?action=client">
                            <table id="compteClient" class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                                <tbody>
                                    <tr>
                                        <td class="has-text-left subtitle has-text-dark">
                                        <fmt:message key="BuyPageName"></fmt:message>
                                        </td>
                                        <td>
                                            <input class="input" type="text" name="nom">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="has-text-left subtitle has-text-dark">
                                        <fmt:message key="BuyPageFName"></fmt:message>
                                        </td>
                                        <td>
                                            <input class="input" type="text" name="prenom">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="has-text-left subtitle has-text-dark">
                                        <fmt:message key="BuyPageAddress"></fmt:message>
                                        </td>
                                        <td>
                                            <input class="input" type="text" name="adresse">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="has-text-left subtitle has-text-dark">
                                        <fmt:message key="BuyPageCity"></fmt:message>
                                        </td>
                                        <td>
                                            <input class="input" type="text" name="ville">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="has-text-left subtitle has-text-dark">
                                        <fmt:message key="BuyPagePc"></fmt:message>(A0A0A0)
                                        </td>
                                        <td>
                                            <input class="input" type="text" name="codePostal" pattern="[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]"> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><p class="subtitle has-text-left"><fmt:message key="ConnectionPasswordField"></fmt:message></p></td>
                                        <td>
                                            <input class="input is-small" type="password" name="mdp">
                                        </td>
                                    </tr>
                                    <tr >
                                        <td colspan="2"><p class="has-text-centered">
                                                <input class="button is-dark" type="submit" name="btnCreation" value="<fmt:message key="AccountCreationButtonValue"></fmt:message>">
                                            </p>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                    <a class="button is-text has-text-grey-light is-medium" href="ControleListe?action=accueil"><fmt:message key="ErrorPageLink"></fmt:message></a>
                </div>
            </div>
            <br />

        <%@include file="../jspf/footer.jspf" %>
        <script src="js/jsCreationCompte.js"></script>
    </body>
</html>
