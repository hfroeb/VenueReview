/**
 * Created by halleyfroeb on 11/9/16.
 */

$(':radio').change(
    function () {
        $('.choice').text($(this).val() + ' stars');
    }
)