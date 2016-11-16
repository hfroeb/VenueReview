/**
 * Created by halleyfroeb on 11/9/16.
 */

$(':radio').change(
    function () {
        $('.choice').text($(this).val() + ' stars');
    }
)

// function getRating() {
//     var rating = document.getElementById("rating").innerHTML;
//     if(rating == 1){
//         var stars = "★";
//     }if(rating == 2){
//         var stars = "★★";
//     } if(rating == 3) {
//         var stars = "★★★";
//     }if(rating == 4) {
//         var stars = "★★★★";
//     }if(rating == 5){
//         var stars= "★★★★★";
//     }
//     document.write(stars);
//     return stars;
// }
// $.get("/stars", getRating());



