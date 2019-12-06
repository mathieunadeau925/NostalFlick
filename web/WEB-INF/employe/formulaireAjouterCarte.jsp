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
                        <c:if test="${carteInvalide}">
                            <h1 class="title has-text-white" >
                                <fmt:message key="CardSaveInvalid"></fmt:message>
                                </h1>
                        </c:if>

                        <c:if test="${noClientInvalide}">
                            <h1 class="title has-text-white" >
                                <fmt:message key="CsNumInvalid"></fmt:message>
                                </h1>
                        </c:if>
                        <form name="formAddCard" method="post" action="ControleEmpCarte?action=ajouterCarte">
                            <table class="table has-background-white is-fullwidth">
                                <thead>
                                    <tr>
                                        <th class="has-text-left subtitle has-text-dark"><fmt:message key="BuyPageCc"></fmt:message></th>
                                        <th class="has-text-left subtitle has-text-dark"><fmt:message key="BuyPageCardType"></fmt:message></th>
                                        <th class="has-text-left subtitle has-text-dark"><fmt:message key="BuyPageExpDate"></fmt:message></th>
                                        <th class="has-text-right subtitle has-text-dark"><fmt:message key="BuyPageSecurityCode"></fmt:message></th>
                                        <th class="has-text-right subtitle has-text-dark"><fmt:message key="ListCardsClientNo"></fmt:message></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-white">
                                                <input class="input" type="text" name="carteCredit" pattern="[0-9]{16}">
                                            </td>
                                            <td class="has-text-left subtitle has-text-white">
                                                <div class="field">
                                                    <div class="control">
                                                        <div class="select is-info">
                                                            <select name="typeCarte">
                                                                <option value="MASTERCARD">Mastercard</option>
                                                                <option value="VISA">Visa</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="has-text-left subtitle has-text-white">
                                                <input class="input" type="date" name="dateExpiration">
                                            </td>
                                            <td class="has-text-left subtitle has-text-white">
                                                <input class="input" type="text" pattern="[0-9]{3}" name="numVerif">
                                            </td>
                                            <td class="has-text-right subtitle has-text-white">
                                                <input class="input" type="number" name="noClient">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <p class="has-text-centered"><input class="button is-text has-text-grey-light is-medium" type="submit" value="<fmt:message key="CardSaveCard"></fmt:message>"></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <br />

        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>