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
        <c:if test="${produitDelete}">
            <div class="container">
                <div class="block">
                    <div class="columns">
                        <div class="column">
                            <section class="hero is-light">
                                <div class="hero-body">
                                    <h2 class="subtitle">
                                        <fmt:message key="ModifProduitDelete"></fmt:message>
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
                        <form name="formSearch" method="post" action="ControleEmpListeProduits?action=rechercheFilm">
                            <div class="field has-addons has-addons-centered">
                                <div class="control">
                                    <input class="input is-dark is-medium is-expanded" type="text" name="txtRecherche" placeholder="<fmt:message key="ClientSearchHelp"></fmt:message>">
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
        <c:if test="${rechercheProduit}">

            <div class="container">
                <div class="block">
                    <div class="columns is-multiline">
                        <!-- produits -->
                        <c:if test="${listeProduits.size() <= 0}">
                            <div class="column">
                                <section class="hero is-light">
                                    <div class="hero-body">
                                        <h2 class="subtitle">
                                            <fmt:message key="ClientSearchEmpty"></fmt:message>
                                            </h2>
                                        </div>
                                    </section>
                                </div>
                        </c:if>
                        <c:if test="${listeProduits.size() > 0}">
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
                                                <p class="has-text-light subtitle">Stock : ${produit.qteProduit}</p>
                                                <div class="has-text-centered">
                                                    <a class="button is-danger" href="ControleEmpProduit?action=voirProduit&noProduit=${produit.noProduit}"><fmt:message key="EmpModifyProduct"></fmt:message></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:if>


        <c:if test="${!rechercheProduit}">
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
                                            <p class="has-text-light subtitle">Stock : ${produit.qteProduit}</p>
                                            <div class="has-text-centered">
                                                <a class="button is-danger" href="ControleEmpProduit?action=voirProduit&noProduit=${produit.noProduit}"><fmt:message key="EmpModifyProduct"></fmt:message></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </c:forEach>
                    </div><!-- fin des produits-->
                </div>
            </div>
        </c:if>
        <br>
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
