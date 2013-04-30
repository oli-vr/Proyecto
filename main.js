$(document).ready(function () {
  $("button").click(function () {
    try {
      var result = jMusic.parse($("textarea").val())
      $("span").html(result);
    } catch (e) {
      $("span").html(String(e));
    }
  });
});
