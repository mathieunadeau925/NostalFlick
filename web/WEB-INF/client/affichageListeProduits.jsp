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
        <!-- Premiere colonne -->
        <br>
        <div class="container">
            <div class="block">
                <!-- produits -->
                <div class="columns is-multiline">
                    <c:forEach var="produit" items="${listeProduits}" >
                        <div class="column is-12-mobile is-4-tablet is-3-desktop  is-3-widescreen">
                            <div class="card has-background-black">
                                <div class="card-image">
                                    <figure class="image is-2by3">
                                        <img src="${produit.lienProduit}" alt="${produit.nomProduit}">
                                    </figure>
                                </div>
                                <div class="card-content">
                                    <div class="content has-text-left">
                                        <p class="has-text-light subtitle">${produit.prixProduit} $</p>
                                        <p class="has-text-light subtitle">${produit.dureeProduit}</p>
                                        <c:if test="${produit.qteProduit > 0}">
                                            <p class="has-text-link"><fmt:message key="ProductListStock"></fmt:message></p>
                                                <div class="has-text-centered">
                                                    <a class="button is-link" href="ControlePanier?action=addCart&produit=${produit.noProduit}"><fmt:message key="ProductListAddCart"></fmt:message></a>
                                                </div>
                                        </c:if>
                                        <c:if test="${produit.qteProduit <= 0}">
                                            <p class="has-text-danger"><fmt:message key="ProductListOutOfStock"></fmt:message></p>
                                                <div class="has-text-centered">
                                                    <a class="button is-dark"><fmt:message key="ProductListOutOfStock"></fmt:message></a>
                                                </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div><!-- fin des produits-->
            </div>
        </div>
    <br>
    <%@include file="../jspf/footer.jspf" %>
</body>
</html>
