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
            <input type="hidden" name="viewid" value="/WEB-INF/pageConnexion.jsp">
            <div class="container-fluid">
                <div class="block">
                    <div class="columns">
                        <div class="column is-12">
                            <figure class="image">
                                <img class ="is-rounded" src="./images/dsc9113-16-9.1280x240.jpg" id="imgBarre" alt="" />
                                <hr>
                            </figure>
                            <h1 class="title has-text-light">
                            <fmt:message key="ConnectionTitle"></fmt:message>
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <div class="column">
                            <form name="formAuthentification" method="post" action="ControleAuthentification">
                                <section class="section">
                                    <div class="columns is-centered">
                                        <div class="column is-narrow">
                                            <table class="table is-bordered is-striped is-narrow is-hoverable">
                                                <thead>
                                                    <tr>
                                                        <th colspan="4">
                                                            <div class="is-size-2 has-text-centered">
                                                            <c:if test="${mdpInvalide}">
                                                                <p><fmt:message key="ConnectionInvalidPwd"></fmt:message></p>
                                                            </c:if>
                                                            <c:if test="${!mdpInvalide}">
                                                                <p><fmt:message key="ConnectionNoPwdEntered"></fmt:message></p>
                                                            </c:if>
                                                        </div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <c:if test="${sessionScope.isEmploye}">
                                                            <input type="hidden" name="userType" value="admin">
                                                        </c:if>
                                                        <c:if test="${!sessionScope.isEmploye}">
                                                            <input type="hidden" name="userType" value="client">
                                                        </c:if>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><p class="subtitle has-text-right"><fmt:message key="ConnectionUserNameField"></fmt:message></p></td>
                                                        <td> 
                                                            <div class="field">
                                                                <div class="control">
                                                                    <div class="select is-info">
                                                                        <select name="selectPersonne">
                                                                        <c:forEach var="personne" items="${sessionScope.liste}" >
                                                                            <option value="${personne.numero}">${personne.nom} , ${personne.prenom}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><p class="subtitle has-text-right"><fmt:message key="ConnectionPasswordField"></fmt:message></p></td>
                                                        <td>
                                                            <input class="input is-small" type="password" name="mdp">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4"><p class="has-text-centered">
                                                                <input class="button is-dark" type="submit" name="btnConnecter" value="<fmt:message key="ConnectionConnectBtn"></fmt:message>">
                                                            </p>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                        </div>
                                    </div>

                                </section>

                            </form>
                        </div>
                    </div>
                    <a class="button is-text has-text-grey-light is-medium" href="ControleListe?action=accueil"><fmt:message key="ErrorPageLink"></fmt:message></a>
                </div>

            </div>
            <br />

        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>