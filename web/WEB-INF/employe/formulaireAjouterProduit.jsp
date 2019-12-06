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
                        <c:if test="${produitAjoute}">
                            <h1 class="title has-text-white" >
                                <fmt:message key="FormAddProduitSuccess"></fmt:message>
                                </h1>
                        </c:if>

                        <c:if test="${produitRefuse}">
                            <h1 class="title has-text-white" >
                                <fmt:message key="FormAddProduitError"></fmt:message>
                                </h1>
                        </c:if>
                        <form name="formAddProduit" method="post" action="ControleEmpProduit?action=ajouterProduit">
                            <table class="table has-background-white is-fullwidth">
                                <thead>
                                    <tr>
                                        <th class="has-text-centered subtitle has-text-dark"><fmt:message key="ConfirmProductHeader"></fmt:message></th>
                                    <th class="has-text-centered subtitle has-text-dark"><fmt:message key="AddProductImg"></fmt:message></th>
                                        <th class="has-text-centered subtitle has-text-dark"><fmt:message key="ConfirmProductPrice"></fmt:message></th>
                                        <th class="has-text-centered subtitle has-text-dark"><fmt:message key="AddProductTime"></fmt:message></th>
                                        <th class="has-text-centered subtitle has-text-dark"><fmt:message key="AddProductQty"></fmt:message></th>                   
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="has-text-left subtitle has-text-white">
                                                <input class="input" type="text" name="nomProduit">
                                            </td>
                                            <td class="has-text-left subtitle has-text-white">
                                                <div class="field has-addons">
                                                    <div class="control">
                                                        <input class="input" type="text" name="pathImg1" value="images/" readonly>
                                                    </div>
                                                    <div class="control">
                                                        <input class="input" type="text" name="pathImg" placeholder="MovieName.jpg">
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="has-text-left subtitle has-text-white">
                                                <input class="input" type="number" name="prixProduit" step="0.01" min="0" max="100">
                                            </td>
                                            <td class="has-text-left subtitle has-text-white">
                                                <input class="input" type="number" name="tempsProduit">
                                            </td>
                                            <td class="has-text-left subtitle has-text-white">
                                                <input class="input" type="number" name="qteProduit">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <p class="has-text-centered"><input class="button is-text has-text-grey-light is-medium" type="submit" value="<fmt:message key="AddProductButton"></fmt:message>"></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <br />

        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>