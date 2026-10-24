const API_BASE_URL = 'http://localhost:8080/api/v1/auth';

export const apiService = {
  // Sign up / Register a new user
  // Backend endpoint: POST /api/v1/auth/register
  // Request body: UserDTO { email, password, name, provider, roles }
  async signup(userData) {
    try {
      const response = await fetch(`${API_BASE_URL}/register`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          email: userData.email,
          password: userData.password,
          name: userData.name || userData.email.split('@')[0],
          roles: userData.roles || [],
        }),
      });

      if (!response.ok) {
        let errorMsg = `Registration failed with status ${response.status}`;
        try {
          const errData = await response.json();
          errorMsg = errData.message || errData.error || errorMsg;
        } catch {
          const text = await response.text();
          if (text) errorMsg = text;
        }
        throw new Error(errorMsg);
      }

      return await response.json();
    } catch (error) {
      console.error('Signup Error:', error);
      throw error;
    }
  },

  // Login user with JWT
  // Backend endpoint: POST /api/v1/auth/login
  // Request body: LoginRequest { email, password }
  async login(email, password) {
    try {
      const response = await fetch(`${API_BASE_URL}/login`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        credentials: 'include', // Includes HttpOnly refresh token cookie
        body: JSON.stringify({
          email,
          password,
        }),
      });

      if (!response.ok) {
        let errorMsg = `Login failed (${response.status})`;
        try {
          const errData = await response.json();
          errorMsg = errData.message || errData.error || errorMsg;
        } catch {
          const text = await response.text();
          if (text) errorMsg = text;
        }
        throw new Error(errorMsg);
      }

      const data = await response.json();
      if (data.accessToken) {
        localStorage.setItem('accessToken', data.accessToken);
      }
      if (data.user) {
        localStorage.setItem('currentUser', JSON.stringify(data.user));
      }
      return data;
    } catch (error) {
      console.error('Login Error:', error);
      throw error;
    }
  },

  // Refresh token
  // Backend endpoint: POST /api/v1/auth/refresh
  async refreshToken() {
    try {
      const response = await fetch(`${API_BASE_URL}/refresh`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        credentials: 'include',
      });

      if (!response.ok) {
        throw new Error('Failed to refresh token');
      }

      const data = await response.json();
      if (data.accessToken) {
        localStorage.setItem('accessToken', data.accessToken);
      }
      return data;
    } catch (error) {
      console.error('Refresh Token Error:', error);
      throw error;
    }
  },

  // Logout
  // Backend endpoint: POST /api/v1/auth/logout
  async logout() {
    try {
      await fetch(`${API_BASE_URL}/logout`, {
        method: 'POST',
        credentials: 'include',
      });
    } catch (error) {
      console.error('Logout error:', error);
    } finally {
      localStorage.removeItem('accessToken');
      localStorage.removeItem('currentUser');
    }
  },

  // Helper to get authorization headers
  getAuthHeaders() {
    const token = localStorage.getItem('accessToken');
    return {
      'Content-Type': 'application/json',
      ...(token ? { Authorization: `Bearer ${token}` } : {}),
    };
  },
};
