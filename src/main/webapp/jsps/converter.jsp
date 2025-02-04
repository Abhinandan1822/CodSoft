<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTL for dynamic content -->

<html>
<head>
    <title>Currency Converter 💱</title>
    <style>
        body { font-family: Arial; background-color: #f4f4f4; text-align: center; padding: 50px; }
        .container { background: white; padding: 20px; border-radius: 10px; width: 300px; margin: auto; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        select, input { width: 90%; padding: 10px; margin: 10px 0; }
        button { background-color: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; }
        button:hover { background-color: #0056b3; }
        .result { margin-top: 20px; font-size: 20px; color: green; }
        .error { color: red; }
    </style>
</head>

<body>
    <div class="container">
        <h2>Currency Converter 💱</h2>

        <!-- Form to input conversion details -->
        <form action="convert" method="post">
            <label>Base Currency:</label>
            <select name="baseCurrency">
                <!-- Retains the selected value after form submission -->
                <option value="USD" ${baseCurrency == 'USD' ? 'selected' : ''}>USD ($)</option>
                <option value="EUR" ${baseCurrency == 'EUR' ? 'selected' : ''}>EUR (€)</option>
                <option value="GBP" ${baseCurrency == 'GBP' ? 'selected' : ''}>GBP (£)</option>
                <option value="INR" ${baseCurrency == 'INR' ? 'selected' : ''}>INR (₹)</option>
                <option value="JPY" ${baseCurrency == 'JPY' ? 'selected' : ''}>JPY (¥)</option>
            </select>

            <label>Target Currency:</label>
            <select name="targetCurrency">
                <option value="USD" ${targetCurrency == 'USD' ? 'selected' : ''}>USD ($)</option>
                <option value="EUR" ${targetCurrency == 'EUR' ? 'selected' : ''}>EUR (€)</option>
                <option value="GBP" ${targetCurrency == 'GBP' ? 'selected' : ''}>GBP (£)</option>
                <option value="INR" ${targetCurrency == 'INR' ? 'selected' : ''}>INR (₹)</option>
                <option value="JPY" ${targetCurrency == 'JPY' ? 'selected' : ''}>JPY (¥)</option>
            </select>

            <label>Amount:</label>
            <input type="number" name="amount" value="${amount}" required />

            <button type="submit">Convert</button>
        </form>

        <!-- Display the converted amount if available -->
        <c:if test="${not empty convertedAmount}">
            <div class="result">
                Converted Amount: ${currencySymbol} ${convertedAmount}
            </div>
        </c:if>

        <!-- Display error messages if any -->
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
    </div>
</body>
</html>
