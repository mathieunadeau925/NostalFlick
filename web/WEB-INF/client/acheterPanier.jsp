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
        <c:if test="${carteInvalide}">
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <div class="column">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                        <fmt:message key="CreditCardError"></fmt:message>
                                        </h2>
                                    </div>
                                </section>
                                <br>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
                <br />
        </c:if>

        <div class="container">
            <div class="block">
                <div class="columns">
                    <div class="column">
                        <div class="content">
                            <table class="table has-background-light">
                                <tbody>
                                    <c:forEach var="produit" items="${sessionScope.panier}">
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <span>${produit.nomProduit}</span>
                                            </td>
                                            <td class="has-text-right subtitle has-text-dark">
                                                <span>${produit.prixProduit}  $</span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <th colspan="2">
                                            <p class="has-text-dark subtitle has-text-right"><fmt:message key="CartPriceTotal"></fmt:message> ${sessionScope.prixTotalAvecTaxes} $</p>
                                            </th>
                                        </tr>
                                    </tbody>
                                </table>
                                <br>
                                <form name="formAcheter" method="post" action="ControleAchatPanier">
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
                                                <fmt:message key="BuyPageName"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="nom" value="${sessionScope.client.nom}" readonly>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageFName"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="prenom" value="${sessionScope.client.prenom}" readonly>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageAddress"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="adresse" value="${sessionScope.client.adresse}" readonly>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageCity"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="ville" value="${sessionScope.client.ville}" readonly>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPagePc"></fmt:message>
                                                </td>
                                                <td>
                                                    <input class="input" type="text" name="codePostal" value="${sessionScope.client.codePostal}" readonly> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageCc"></fmt:message>
                                                </td>
                                                <td>
                                                    <input required class="input" type="text" name="carteCredit" pattern="[0-9]{16}" value="${sessionScope.client.carteCredit}">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageCardType"></fmt:message>
                                                </td>
                                                <td>
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
                                            </tr>
                                            <tr>
                                                <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageExpDate"></fmt:message>
                                                </td>
                                                <td>
                                                    <input required class="input" type="date" name="dateExpiration">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="has-text-left subtitle has-text-dark">
                                                <fmt:message key="BuyPageSecurityCode"></fmt:message>
                                                </td>
                                                <td>
                                                    <input required class="input" type="password" name="codeSecurite">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <p class="has-text-dark subtitle has-text-right"><fmt:message key="CartPriceTotal"></fmt:message> ${sessionScope.prixTotalAvecTaxes} $</p>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <div class="has-text-centered">
                                        <input class="button is-medium is-link" type="submit" name="btnEnvoyer" value="<fmt:message key="BuyPageBtn"></fmt:message>">
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
