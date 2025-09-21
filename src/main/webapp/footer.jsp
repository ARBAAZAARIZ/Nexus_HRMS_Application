<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Footer Showcase</title>
<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<!-- Optional pastel styling -->
<style>
    .main-footer {
        background: linear-gradient(to right, #f6f1f1, #e0f7fa);
        color: #333;
        padding: 20px;
        font-family: 'Segoe UI', sans-serif;
        border-top: 2px solid #ccc;
    }
    .main-footer a {
        color: #007bff;
        text-decoration: none;
    }
    .main-footer a:hover {
        text-decoration: underline;
    }
    .footer-social {
        margin-top: 10px;
    }
    .footer-social i {
        margin-right: 10px;
        color: #555;
        transition: color 0.3s;
    }
    .footer-social i:hover {
        color: #007bff;
    }
    .footer-right {
        float: right;
        font-size: 0.9em;
        color: #666;
    }
</style>
</head>
<body>

<footer class="main-footer">
    <strong>&copy; 2021–2028 <a href="https://nexus-hrms.io/">Nexus HRMS</a></strong> — Empowering teams with clarity and control.<br>
    All rights reserved.

    <div class="footer-social">
        <a href="#"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-linkedin-in"></i></a>
        <a href="#"><i class="fab fa-github"></i></a>
    </div>

    <div class="footer-right">
        <b>Version</b> 3.2.0 | Crafted with ❤️ in Mumbai
    </div>
</footer>

</body>
</html>
