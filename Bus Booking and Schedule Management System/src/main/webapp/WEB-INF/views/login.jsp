<jsp:include page="common/navbar.jsp"/>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- Fullscreen background with bus photo + gradient overlay + floating animation -->

<div id="login-root" class="relative min-h-screen flex items-center justify-center p-6 overflow-hidden bg-gray-900">

    ```
    <!-- Background bus photo -->
    <div class="absolute inset-0 bg-cover bg-center animate-bgMove" style="background-image: url('https://images.unsplash.com/photo-1529070538774-1843cb3265df?auto=format&fit=crop&w=1950&q=80');"></div>

    <!-- Gradient overlay -->
    <div class="absolute inset-0 bg-gradient-to-br from-indigo-700/60 via-purple-600/50 to-pink-500/50 mix-blend-multiply"></div>

    <!-- Floating colorful blobs -->
    <div class="absolute w-72 h-72 bg-pink-400 rounded-full mix-blend-multiply filter blur-3xl opacity-30 animate-blob"></div>
    <div class="absolute w-72 h-72 bg-purple-400 rounded-full mix-blend-multiply filter blur-3xl opacity-30 animate-blob animation-delay-2000"></div>
    <div class="absolute w-72 h-72 bg-indigo-400 rounded-full mix-blend-multiply filter blur-3xl opacity-30 animate-blob animation-delay-4000"></div>

    <!-- Login Card -->
    <div class="relative w-full max-w-md z-10">
        <form id="login-form" class="bg-white/90 backdrop-blur-md rounded-2xl shadow-2xl p-8 space-y-6 border border-gray-200">
            <div class="text-center">
                <i class="fas fa-sign-in-alt text-indigo-500 text-5xl mb-3 drop-shadow-md"></i>
                <h1 class="text-3xl font-extrabold text-gray-800 tracking-wide">Sign In</h1>
                <p class="text-sm text-gray-500">Welcome back! Please login to continue.</p>
            </div>

            <div>
                <label class="block text-sm font-medium text-gray-700 mb-1">Email</label>
                <div class="relative">
                    <i class="fas fa-envelope absolute left-3 top-1/2 -translate-y-1/2 text-indigo-400"></i>
                    <input id="email" type="email" placeholder="you@example.com" class="w-full pl-10 pr-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-pink-400 focus:border-pink-400 transition"/>
                </div>
                <span id="email-err" class="text-red-500 text-xs hidden">Invalid email</span>
            </div>

            <div>
                <label class="block text-sm font-medium text-gray-700 mb-1">Password</label>
                <div class="relative">
                    <i class="fas fa-lock absolute left-3 top-1/2 -translate-y-1/2 text-indigo-400"></i>
                    <input id="password" type="password" placeholder="••••••••" class="w-full pl-10 pr-10 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-400 focus:border-purple-400 transition"/>
                    <button type="button" id="toggle-pw" class="absolute right-3 top-1/2 -translate-y-1/2 text-gray-400 hover:text-indigo-600 transition">
                        <i class="fas fa-eye"></i>
                    </button>
                </div>
                <span id="password-err" class="text-red-500 text-xs hidden">Min 6 characters</span>
            </div>

            <button id="submit-btn" type="submit" class="w-full bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 text-white py-2 rounded-lg hover:opacity-90 transition transform hover:scale-[1.02] shadow-lg flex items-center justify-center space-x-2">
                <span id="btn-text" class="font-medium">Login</span>
                <i id="btn-icon" class="fas fa-sign-in-alt"></i>
            </button>

            <div class="text-center text-sm">
                <span class="text-gray-600">New here?</span>
                <a href="register" class="text-pink-500 font-medium hover:underline ml-1">Create an account</a>
            </div>
        </form>
    </div>
    ```

</div>

<script src="/js/login.js"></script>

<!-- Extra animations -->

<style>
    .animate-blob {
        animation: blob 8s infinite;
    }
    .animation-delay-2000 {
        animation-delay: 2s;
    }
    .animation-delay-4000 {
        animation-delay: 4s;
    }
    @keyframes blob {
        0% { transform: translate(0px, 0px) scale(1); }
        33% { transform: translate(30px, -50px) scale(1.1); }
        66% { transform: translate(-20px, 20px) scale(0.9); }
        100% { transform: translate(0px, 0px) scale(1); }
    }

    .animate-bgMove {
        animation: bgMove 30s infinite alternate ease-in-out;
    }
    @keyframes bgMove {
        from { transform: scale(1) translate(0, 0); }
        to { transform: scale(1.1) translate(-20px, -20px); }
    }
</style>
