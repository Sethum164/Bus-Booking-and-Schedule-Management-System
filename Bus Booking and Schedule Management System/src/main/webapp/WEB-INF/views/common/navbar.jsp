<!-- navbar.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bus Booking Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="/js/navbar.js" defer></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap');

        body {
            font-family: 'Poppins', sans-serif;
        }

        nav {
            background: linear-gradient(135deg, rgba(255, 179, 71, 0.9), rgba(255, 95, 109, 0.9));
            background-size: cover;
            background-position: center;
            background-blend-mode: overlay;
            backdrop-filter: blur(6px);
        }

        .nav-link {
            transition: all 0.3s ease;
        }

        .nav-link:hover {
            color: #FFD700;
            transform: translateY(-2px) scale(1.05);
        }

        .brand-title {
            background: linear-gradient(90deg, #ffda44, #ff7eb3);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            font-weight: 700;
            letter-spacing: 1px;
        }

        .bus-background {
            background: url('https://i.ibb.co/2kWQG7m/colorful-bus.jpg') no-repeat center center;
            background-size: cover;
        }
    </style>
</head>
<body class="bg-gray-100">

<!-- Navbar with bus photo background -->
<nav class="bus-background shadow-lg">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 bg-black/50 rounded-xl mt-2">
        <div class="flex items-center justify-between h-16">
            <div class="flex items-center">
                <div class="flex-shrink-0">
                    <a href="/"><h1 class="brand-title text-2xl">🚌 BusBooking Manager</h1></a>
                </div>
            </div>
            <div class="hidden md:block">
                <div class="ml-10 flex items-baseline space-x-6" id="nav-links">
                    <!-- Links will be dynamically inserted here by navbar.js -->
                    <a href="#" class="nav-link text-white font-medium">Home</a>
                    <a href="#" class="nav-link text-white font-medium">Bookings</a>
                    <a href="#" class="nav-link text-white font-medium">Feedback</a>
                    <a href="#" class="nav-link text-white font-medium">Profile</a>
                </div>
            </div>
            <div class="md:hidden">
                <button id="mobile-menu-button" class="text-white hover:text-yellow-300 focus:outline-none">
                    <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M4 6h16M4 12h16M4 18h16" />
                    </svg>
                </button>
            </div>
        </div>
    </div>
    <div class="md:hidden hidden" id="mobile-menu">
        <div class="px-2 pt-2 pb-3 space-y-1 sm:px-3 bg-black/60 rounded-b-lg" id="mobile-nav-links">
            <!-- Mobile links will be dynamically inserted here by navbar.js -->
        </div>
    </div>
</nav>

</body>
</html>
