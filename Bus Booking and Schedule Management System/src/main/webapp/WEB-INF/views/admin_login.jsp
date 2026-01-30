<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

<div class="min-h-screen bg-gradient-to-br from-purple-50 to-indigo-100 flex items-center justify-center p-4">
    <form id="bus-admin-login-form" class="bg-white rounded-2xl shadow-xl p-8 w-full max-w-md space-y-6">
        <div class="text-center">
            <i class="fas fa-bus text-purple-600 text-4xl mb-2"></i>
            <h1 class="text-2xl font-bold text-gray-800">Bus Admin Login</h1>
        </div>
        <div>
            <label class="block text-sm font-medium text-gray-700 mb-1">Admin Email</label>
            <div class="relative">
                <i class="fas fa-envelope absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"></i>
                <input id="bus-admin-email" type="email" placeholder="busadmin@bus.com" class="w-full pl-10 pr-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-500"/>
            </div>
        </div>
        <div>
            <label class="block text-sm font-medium text-gray-700 mb-1">Admin Password</label>
            <div class="relative">
                <i class="fas fa-lock absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"></i>
                <input id="bus-admin-password" type="password" placeholder="••••••••" class="w-full pl-10 pr-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-500"/>
            </div>
        </div>
        <button id="bus-submit-btn" type="submit" class="w-full bg-purple-600 text-white py-2 rounded-lg hover:bg-purple-700 transition">Login</button>
    </form>
</div>

<script>
    document.getElementById('bus-admin-login-form').addEventListener('submit', e => {
        e.preventDefault();
        const email = document.getElementById('bus-admin-email').value.trim();
        const password = document.getElementById('bus-admin-password').value.trim();
        if (email === 'busadmin@bus.com' && password === 'bus123') {
            location.href = '/admin-dashboard';
        } else {
            alert('Invalid bus admin credentials');
        }
    });
</script>
