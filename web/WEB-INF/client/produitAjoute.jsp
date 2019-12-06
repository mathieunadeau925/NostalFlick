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
        <div class="container">
            <div class="block">
                <div class="columns">
                    <div class="column">
                        <section class="hero is-light">
                            <div class="hero-body">
                                <h2 class="subtitle">
                                    <fmt:message key="ConfirmProductAddedMessage"></fmt:message> ${sessionScope.client.prenom}!
                                    </h2>
                                </div>
                            </section>
                            <br>
                            <br>
                        </div>
                    </div>
                    <section class="section">
                        <div class="columns">
                            <div class="column">
                                <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                                    <thead>
                                        <tr>
                                            <th>
                                                <div class="is-size-2 has-text-centered">
                                                    <p><fmt:message key="ConfirmProductHeader"></fmt:message></p>
                                                </div>
                                            </th>
                                            <th>
                                                <div class="is-size-2 has-text-centered">
                                                    <p><fmt:message key="ConfirmProductPrice"></fmt:message></p>
                                                </div>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <div class="is-size-2 has-text-centered">
                                                    <p>${produit.nomProduit}</p>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="is-size-2 has-text-centered">
                                                <p>${produit.prixProduit}  $</p>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </section>
            </div>
        </div>


        <br />

        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
