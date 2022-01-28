$(document).ready(function(){

    // List animation
    $('nav li').hover(
        function() {
            $('ul', this).stop().slideDown(200);
        },
        function() {
            $('ul', this).stop().slideUp(200);
        }
    );

    // Dynamically Populate Brand Names for Nav
    $('.brand').hover(
        function () {
            $.get("http://localhost:8080/brands", function(brands){
                $('.brand_menu').empty();
                for (let i = 0; i < brands.length; i++) {
                    $('.brand_menu').append( '<li class="brand_name" id="' + brands[i]["id"] + '"><a href="#">' + brands[i]['brand_name'] + '</a></li>' );
                }
            })
        }
    );

    // Populate Info Div With Brand Products
    $('li').on("click", ".brand_name",
        function() {
            let id = $(this).attr('id');
            brand_page(id);
    });

    // Handle Product Sorters
    $('body').on("click", "a.sort_links",
        function() {
            let type = $(this).attr('id');
            if (type !== 'all') {
                $('.product_table tr').each(function () {
                    if ($(this).find("td:eq(0)").text().replace(' ', '_') !== type) {
                        $(this).attr("hidden", true);
                    } else {
                        $(this).attr("hidden", false);
                    }
                })
            } else {
                $('.product_table tr').each(function () {
                        $(this).attr("hidden", false)
                    }
                )
            }
        });

    // Review Page
    $('body').on("click", "a.review_link",
        function() {
            let id = $(this).attr('id');
            review_page(id)
        })

    // Handle Review Delete
    $('body').on("click", "a.review_delete",
        function() {
            let id = $(this).attr('id');
            $.get("http://localhost:8080/reviews/" + id, function (review) {
                if (confirm("Are you sur you want to DELETE this review:\n\n" + review["review"])) {
                    $.ajax({
                        url: 'http://localhost:8080/reviews/' + id,
                        type: 'DELETE',
                        success: function(result) {
                            $('.product_table tr').each(function () {
                                if ($(this).find("td:eq(2)").text() === review["review"]) {
                                    $(this).remove();
                                }
                            })
                        }
                    });
                }
            })
        })

    // Handle Review Form Setup Add
    $('body').on("click", "a.review_add",
        function() {
            let id = $(this).attr('id');
            $.get("http://localhost:8080/products/" + id + "/reviews", function(product){
                let review_header = "<p class='sort_by'>Add a Review for " + product[0][0] + " " + product[0][1] + " " + product[0][2]
                    + "</p><p class='sort_by'>$" + product[0][3] + "</p>";
                $('.info_div').empty().append(review_header);
                let $form = $("<form class='new_review'></form>")
                $form.append("<label for='rating'>Rating: </label><input type='number' id='rating' name='rating' max='5'>/5<br><br>")
                $form.append("<label for='review'>Review: </label><textarea id='review' name='review'></textarea><br><br>")
                $form.append("<label for='product' hidden></label><input type='number' id='product' name='product' value='" + id + "' hidden>")
                $form.append("<input type='submit' value='Submit'>")
                $('.info_div').append($form);
            })
    })

    // Handle Review Form Setup Modify
    $('body').on("click", "a.review_modify",
        function() {
            let id = $(this).attr('id');
            $.get("http://localhost:8080/reviews/" + id + "/full", function(review){
                let review_header = "<p class='sort_by'>Modify a Review for " + review[0][0] + " " + review[0][1] + " " + review[0][2]
                    + "</p><p class='sort_by'>$" + review[0][3] + "</p>";
                $('.info_div').empty().append(review_header);
                let $form = $("<form class='modify_review'></form>")
                $form.append("<label for='rating'>Rating: </label><input type='number' id='rating' name='rating' max='5' value='" + review[0][6] + "'>/5<br><br>")
                $form.append("<label for='review'>Review: </label><textarea id='review' name='review'>" + review[0][4] + "</textarea><br><br>")
                $form.append("<label for='product' hidden></label><input type='number' id='product' name='product' value='" + review[0][8] + "' hidden>")
                $form.append("<label for='date' hidden></label><input type='text' id='date' name='date' value='" + review[0][5] + "' hidden>")
                $form.append("<label for='r_id' hidden></label><input type='text' id='r_id' name='r_id' value='" + id + "' hidden>")
                $form.append("<input type='submit' value='Submit'>")
                $('.info_div').append($form);
            })
        })

    // Handle Review Add
    $('body').on("submit", "form.new_review", function(review) {
        review.preventDefault();
        let data = $("form.new_review :input").serializeArray();
        let d = new Date();
        let date = d.getFullYear() + "/" + (d.getMonth()+1) + "/" + d.getDate();
        let post_data = {"rating": data[0]["value"], "review": data[1]["value"], "product_id": data[2]["value"], "review_date": date};
        $.ajax({
                url: "http://localhost:8080/reviews",
                type: "POST",
                data: JSON.stringify(post_data),
                contentType: "application/json; charset=utf-8",
                success: function() {
                    let id = data[2]["value"];
                    review_page(id);
                }
        })
    })

    // Handle Review Modify
    $('body').on("submit", "form.modify_review", function(review) {
        review.preventDefault();
        let data = $("form.modify_review :input").serializeArray();
        let date = data[3]["value"];
        let put_data = {"rating": data[0]["value"], "review": data[1]["value"], "product_id": data[2]["value"], "review_date": date};
        $.ajax({
            url: "http://localhost:8080/reviews/" + data[4]["value"],
            type: "PUT",
            data: JSON.stringify(put_data),
            contentType: "application/json; charset=utf-8",
            success: function() {
                let id = data[2]["value"];
                review_page(id);
            }
        })
    })

    // Handle Brand/Product Add Form Setup Selection
    $('.brand_product_add').click(
        function() {
                addHeader();
            })

    // Handle Brand Add Form Setup
    $('body').on("click", "#add_brand_form", function() {
        addHeader();
        let $form = $("<form class='add_brand'></form>");
        $form.append("<label for='brand_name'>Brand Name: </label><input type='text' id='brand_name' name='brand_name' required><br><br>");
        $form.append("<label for='brand_site'>Brand Site: </label><input type='text' id='brand_site' name='brand_site'><br><br>");
        $form.append("<label for='phone'>Brand's Phone: </label><input type='tel' id='phone' name='phone' value='123-456-7899'><br><br>");
        $form.append("<input type='submit' value='Submit'>");
        $('.info_div').append($form);
    })

    // Handle Product Add
    $('body').on("submit", "form.add_brand", function(brand) {
        brand.preventDefault();
        let data = $("form.add_brand :input").serializeArray();
        let post_data = {"brand_name": data[0]["value"], "brand_site": data[1]["value"], "phone": data[2]["value"]};
        $.ajax({
            url: "http://localhost:8080/brands",
            type: "POST",
            data: JSON.stringify(post_data),
            contentType: "application/json; charset=utf-8",
            success: function(id) {
                brand_page(id);
            }
        })
    })

    // Handle Product Add Form Setup
    $('body').on("click", "#add_product_form", function() {
        addHeader();
        $.get("http://localhost:8080/brands", function(brands) {
            let brand_menu = "<select id='brand_name' name='brand_name' required>"
            for (let i = 0; i < brands.length; i++) {
                brand_menu += "<option value='" + brands[i]["id"] + "'>" + brands[i]["brand_name"] + "</option>";
            }
            brand_menu += "</select>";
            let $form = $("<form class='add_product'></form>");
            $form.append("<label for='brand_id'>Brand: </label>" + brand_menu + "<br><br>");
            $form.append("<label for='product_name'>Product Name: </label><input type='text' id='product_name' name='product_name'><br><br>");
            $form.append("<label for='product_type'>Product Type: </label><select id='product_type' name='product_type'>" +
                "<option value='Beard Wax'>Beard Wax</option>" +
                "<option value='Beard Balm'>Beard Balm</option>" +
                "<option value='Beard Oil'>Beard Oil</option>" +
                "<option value='Mustache Wax'>Mustache Wax</option></select><br><br>");
            $form.append("<label for='price'>Product Name: </label>$<input type='text' id=price' name='price'><br><br>");
            $form.append("<input type='submit' value='Submit'>");
            $('.info_div').append($form);
        })
    })

    // Handle Product Add
    $('body').on("submit", "form.add_product", function(product) {
        product.preventDefault();
        let data = $("form.add_product :input").serializeArray();
        let post_data = {"brand": data[0]["value"], "product_name": data[1]["value"], "product_type": data[2]["value"], "price": data[3]["value"]};
        $.ajax({
            url: "http://localhost:8080/products",
            type: "POST",
            data: JSON.stringify(post_data),
            contentType: "application/json; charset=utf-8",
            success: function() {
                brand_page(data[0]["value"]);
            }
        })
    })

    // Handle Brand/Product Modify Form Setup Selection Type
    $('.brand_product_modify').click(
        function() {
            modifyHeader();
        })

    // Handle Brand Modify Form Setup Selection
    $('body').on("click", "#modify_brand_form", function(){
            modifyHeader();
            modifyBrandSelector();
        })

    // Handle Product Modify Form Setup Selection
    $('body').on("click", "#modify_product_form", function(){
        modifyHeader();
        modifyProductSelector();
    })

    // Handle Brand Modify Form Setup
    $('body').on("submit", "form.modify_brand_selector", function(brand) {
        brand.preventDefault();
        let data = $("form.modify_brand_selector :input").serializeArray();
        modifyHeader();
        // modifyBrandSelector();
        $.get("http://localhost:8080/brands/" + data[0]["value"], function(old_brand){
            let $form = $("<form class='modify_brand'></form>");
            $form.append("<label for='brand_name'>Brand Name: </label><input type='text' id='brand_name' name='brand_name' value='" + old_brand["brand_name"] + "' required><br><br>");
            $form.append("<label for='brand_site'>Brand Site: </label><input type='text' id='brand_site' name='brand_site' value='" + old_brand["brand_site"] + "'><br><br>");
            $form.append("<label for='phone'>Brand's Phone: </label><input type='tel' id='phone' name='phone' value=''><br><br>");
            $form.append("<label for='b_id' hidden></label><input type='text' id='b_id' name='b_id' value='" + old_brand["id"] + "' hidden>");            $form.append("<input type='submit' value='Submit'>");
            $('.info_div').append($form);
        })
    })

    // Handle Product Modify Form Setup
    $('body').on("submit", "form.modify_product_selector", function(product) {
        product.preventDefault();
        let data = $("form.modify_product_selector :input").serializeArray();
        modifyHeader();
        // modifyProductSelector();
        $.get("http://localhost:8080/products/" + data[0]["value"], function(old_product){
            $.get("http://localhost:8080/brands", function(brands) {
                let brand_menu = "<select id='brand_name' name='brand_name' required>"
                for (let i = 0; i < brands.length; i++) {
                    if (brands[i]["id"] === old_product["id"]){
                        brand_menu += "<option value='" + brands[i]["id"] + "' selected>" + brands[i]["brand_name"] + "</option>";
                    } else{
                        brand_menu += "<option value='" + brands[i]["id"] + "'>" + brands[i]["brand_name"] + "</option>";
                    }
                    brand_menu += "<option value='" + brands[i]["id"] + "'>" + brands[i]["brand_name"] + "</option>";
                }
                brand_menu += "</select>";
                let $form = $("<form class='modify_product'></form>");
                $form.append("<label for='brand_id'>Brand: </label>" + brand_menu + "<br><br>");
                $form.append("<label for='product_name'>Product Name: </label><input type='text' id='product_name' value='" + old_product["product_name"] + "' name='product_name'><br><br>");
                let p_type = "<label for='product_type'>Product Type: </label><select id='product_type' name='product_type'>"
                if (old_product["product_type"] === "Beard Wax") {
                    p_type += "<option value='Beard Wax' selected>Beard Wax</option>"
                } else {
                    p_type += "<option value='Beard Wax'>Beard Wax</option>"
                }
                if (old_product["product_type"] === "Beard Balm") {
                    p_type += "<option value='Beard Balm' selected>Beard Balm</option>"
                } else {
                    p_type += "<option value='Beard Balm'>Beard Balm</option>"
                }
                if (old_product["product_type"] === "Beard Oil") {
                    p_type += "<option value='Beard Oil' selected>Beard Oil</option>"
                } else {
                    p_type += "<option value='Beard Oil'>Beard Oil</option>"
                }
                if (old_product["product_type"] === "Mustache Wax") {
                    p_type += "<option value='Mustache Wax' selected>Mustache Wax</option></select><br><br>"
                } else {
                    p_type += "<option value='Mustache Wax'>Mustache Wax</option></select><br><br>"
                }
                $form.append(p_type);
                $form.append("<label for='price'>Product Name: </label>$<input type='text' id=price' name='price' value='" + old_product["price"] + "'><br><br>");
                $form.append("<label for='product_id' hidden></label><input type='text' id='product_id' name='product_id' value='" + old_product["id"] + "' hidden>")
                $form.append("<input type='submit' value='Submit'>");
                $('.info_div').append($form);
            })
        })
    })

    // Handle Brand Put
    $('body').on("submit", "form.modify_brand", function(brand) {
        brand.preventDefault();
        let data = $("form.modify_brand :input").serializeArray();
        let post_data = {"brand_name": data[0]["value"], "brand_site": data[1]["value"], "phone": data[2]["value"]};
        $.ajax({
            url: "http://localhost:8080/brands/" + data[3]["value"],
            type: "PUT",
            data: JSON.stringify(post_data),
            contentType: "application/json; charset=utf-8",
            success: function() {
                brand_page(data[3]["value"]);
            }
        })
    })

    // Handle Product Put
    $('body').on("submit", "form.modify_product", function(product) {
        product.preventDefault();
        let data = $("form.modify_product :input").serializeArray();
        let post_data = {"brand": data[0]["value"], "product_name": data[1]["value"], "product_type": data[2]["value"], "price": data[3]["value"]};
        $.ajax({
            url: "http://localhost:8080/products/" + data[4]["value"],
            type: "PUT",
            data: JSON.stringify(post_data),
            contentType: "application/json; charset=utf-8",
            success: function() {
                brand_page(data[0]["value"]);
            }
        })
    })

    // Handle Brand/Product Delete Form Setup Selection
    $('.brand_product_delete').click(
        function() {
            deleteHeader();
        })

    // Handle Brand Delete Form Setup Selection
    $('body').on("click", "#delete_brand_form", function(){
        deleteHeader();
        deleteBrandSelector();
    })

    // Handle Product Delete Form Setup Selection
    $('body').on("click", "#delete_product_form", function(){
        deleteHeader();
        deleteProductSelector();
    })

    // Handle Brand Delete
    $('body').on("submit", "form.delete_brand", function(brand) {
        brand.preventDefault();
        let data = $("form.delete_brand :input").serializeArray();
        $.ajax({
            url: "http://localhost:8080/brands/" + data[0]["value"],
            type: "DELETE",
            success: function() {
                deleteHeader();
            }
        })
    })

    // Handle Product Delete
    $('body').on("submit", "form.delete_product", function(product) {
        product.preventDefault();
        let data = $("form.delete_product :input").serializeArray();
        $.ajax({
            url: "http://localhost:8080/products/" + data[0]["value"],
            type: "DELETE",
            success: function() {
                deleteHeader();
            }
        })
    })

    // Handle Pets
    $('.pets').click(function(){
        let pets = "<p class='pet_title'>Sheriff Rocko</p><br><img src='rocko.jpg' alt='The bestest boy'><br><br>"
        pets += "<p class='pet_title'>Queso</p><br><img src='queso.jpg' alt='Gatito Primero'><br><br>"
        pets += "<p class='pet_title'>Kimmy 'Abuelita' Lezama</p><br><img src='kimmy.jpg' alt='The bestest boy'><br><br>"
        $('.info_div').empty().append(pets);
    })

    // Handle Home
    $('.home').click(function() {
        $('.info_div').empty();
    })


    // Review Page Function
    function review_page(id) {
        $.get("http://localhost:8080/products/" + id + "/reviews", function (reviews) {
            let review_header = "<p class='sort_by'>" + reviews[0][0] + " " + reviews[0][1] + " " + reviews[0][2]
                + " Reveiews</p><p class='sort_by'>$" + reviews[0][3] + "</p><p class='select'><a href='#' class='review_add' id='" + id + "'>Add A  Review</a></p>";
            $('.info_div').empty().append(review_header);

            // Populate Reviews
            let review_table = "<table class='product_table'><tr><th>Date</th><th>Rating</th><th>Review</th><th></th></tr>"
            for (let i = 0; i < reviews.length; i++) {
                let next_review = "<tr><td>" + reviews[i][5] + "</td><td>" + reviews[i][6] +
                    "/5</td><td>" + reviews[i][4] + "</td><td><a href='#' class='review_modify' id='" +
                    reviews[i][7] + "'>Modify</a> " + "<a href='#' class='review_delete' id='" +
                    reviews[i][7] + "'>Delete</a></td></tr>"
                review_table += next_review;
            }
            $('.info_div').append(review_table);
        })
    }

    // Brand Page Function
    function brand_page(id) {
        $.get("http://localhost:8080/brands/" + id, function(brand){

            // Sort Bars
            let sort_by = "<p class='sort_by'>" + brand["brand_name"] + " Prodcuts</p><p class='select'> ";
            $.get("http://localhost:8080/brands/" + id + "/products", function(products) {
                let last_type = null;
                for (let i = 0; i < products.length; i++) {
                    if (products[i][2] !== last_type) {
                        last_type = products[i][2];
                        sort_by += " <a class='sort_links' href='#' id='" + products[i][2].replace(' ', '_') + "'>" + products[i][2] + "</a> ";
                    }
                }
                sort_by += " <a class='sort_links' href='#' id='all'>All</a> "
                $('.info_div').empty().append(sort_by);

                // Populate Products
                let product_table = "<table class='product_table'><tr><th>Type</th><th>Name</th><th>Price</th><th>Reviews</th></tr>"
                for (let i = 0; i < products.length; i++) {
                    let next_product = "<tr><td class='type'>" + products[i][2] +"</td><td>" + products[i][1] +
                        "</td><td>" + "$" + products[i][3] + "</td><td><a href='#' class='review_link' id='" +
                        products[i][4] + "'>Reviews</a></td></tr>"
                    product_table += next_product;
                }
                $('.info_div').append(product_table);
            })
        })
    }

    function addHeader () {
        // Handle Brand/Product Add Form Setup
        let add_header = "<p class='sort_by'>Add a Brand or Product</p><p class='select'>" +
            "<a class='sort_links' href='#' id='add_brand_form'>Brand </a>" +
            "<a class='sort_links' href='#' id='add_product_form'>Product</a></p>";
        $('.info_div').empty().append(add_header);
    }

    function modifyHeader() {
        // Hand Brand/Product modify header
        let add_header = "<p class='sort_by'>Modify a Brand or Product</p><p class='select'>" +
            "<a class='sort_links' href='#' id='modify_brand_form'>Brand </a>" +
            "<a class='sort_links' href='#' id='modify_product_form'>Product</a></p>";
        $('.info_div').empty().append(add_header);
    }

    function deleteHeader() {
        // Hand Brand/Product modify header
        let add_header = "<p class='sort_by'>Remove a Brand or Product</p><p class='select'>" +
            "<a class='sort_links' href='#' id='delete_brand_form'>Brand </a>" +
            "<a class='sort_links' href='#' id='delete_product_form'>Product</a></p>";
        $('.info_div').empty().append(add_header);
    }

    function modifyBrandSelector() {
        $.get("http://localhost:8080/brands", function(brands){
            let $form = $("<form class='modify_brand_selector'></form>");
            let brand_menu = "<label for='brand_id'>Select a Brand: </label><select id='brand_id' name='brand_id' required>"
            for (let i = 0; i < brands.length; i++) {
                brand_menu += "<option value='" + brands[i]["id"] + "'>" + brands[i]["brand_name"] + "</option>";
            }
            brand_menu += "</select>";
            $form.append(brand_menu);
            $form.append("<input type='submit' value='Modify'><br><br><br>");
            $('.info_div').append($form);
        })
    }

    function modifyProductSelector() {
        $.get("http://localhost:8080/brands", function(brands){
            let brand_dictionary = {};
            for (let i = 0; i < brands.length; i++) {
                brand_dictionary[brands[i]["id"]] = brands[i]["brand_name"];
            }
            $.get("http://localhost:8080/products", function(products){
                let $form = $("<form class='modify_product_selector'></form>");
                let product_menu = "<label for='product_id'>Select a Product: </label><select id='product_id' name='product_id' required>"
                for (let i = 0; i < products.length; i++) {
                    let b_name = brand_dictionary[products[i]["brand"]]
                    product_menu += "<option value='" + products[i]["id"] + "'>" + b_name + " " + products[i]["product_name"] + "</option>";
                }
                product_menu += "</select>";
                $form.append(product_menu);
                $form.append("<input type='submit' value='Modify'<br><br><br>");
                $('.info_div').append($form);
            })
        })

    }

    function deleteBrandSelector() {
        $.get("http://localhost:8080/brands", function(brands){
            let $form = $("<form class='delete_brand'></form>");
            let brand_menu = "<label for='brand_id'>Select a Brand: </label><select id='brand_id' name='brand_id' required>"
            for (let i = 0; i < brands.length; i++) {
                brand_menu += "<option value='" + brands[i]["id"] + "'>" + brands[i]["brand_name"] + "</option>";
            }
            brand_menu += "</select>";
            $form.append(brand_menu);
            $form.append("<input type='submit' value='Delete'><br><br><br>");
            $('.info_div').append($form);
        })
    }

    function deleteProductSelector() {
        $.get("http://localhost:8080/brands", function(brands){
            let brand_dictionary = {};
            for (let i = 0; i < brands.length; i++) {
                brand_dictionary[brands[i]["id"]] = brands[i]["brand_name"];
            }
            $.get("http://localhost:8080/products", function(products){
                let $form = $("<form class='delete_product'></form>");
                let product_menu = "<label for='product_id'>Select a Product: </label><select id='product_id' name='product_id' required>"
                for (let i = 0; i < products.length; i++) {
                    let b_name = brand_dictionary[products[i]["brand"]]
                    product_menu += "<option value='" + products[i]["id"] + "'>" + b_name + " " + products[i]["product_name"] + "</option>";
                }
                product_menu += "</select>";
                $form.append(product_menu);
                $form.append("<input type='submit' value='Delete'<br><br><br>");
                $('.info_div').append($form);
            })
        })

    }

})
