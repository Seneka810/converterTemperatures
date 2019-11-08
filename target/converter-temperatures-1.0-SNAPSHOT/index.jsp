<%--@elvariable id="temperature" type="converter.ConverterRequest"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Converter</title>
    <script>
        function oninputC(f) {
            if(f.tC.oninput) {
                f.tF.disabled = 1;
                f.tK.disabled = 1;

            }
        }
        function oninputF(f) {
            if (f.tF.oninput) {
                f.tC.disabled = 1;
                f.tK.disabled = 1;
            }
        }

        function oninputK(f) {
            if (f.tK.oninput) {
                f.tC.disabled = 1;
                f.tF.disabled = 1;

            }
        }
    </script>
  </head>
  <body>
      <h3>Input data:</h3>
          <form action="converter-temperatures" method="post">
              <table border="1">
                <tr>
                    <td>tC</td>
                    <td><input type="text" name="tC" size="20" oninput="oninputC(this.form)" /></td>
                </tr>
                <tr>
                    <td>tF</td>
                    <td><input type="text" name="tF" size="20" oninput="oninputF(this.form)" /></td>
                </tr>
                <tr>
                    <td>tK</td>
                    <td><input type="text" name="tK" size="20" oninput="oninputK(this.form)" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Convert"/></td>
                </tr>
              </table>
          </form>
      <h4>Result:</h4>
      <p><input type="text" name="result" size="20" value=${temperature.res}></p>
  </body>
</html>
