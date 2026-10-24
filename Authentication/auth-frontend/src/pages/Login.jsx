import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { LogIn, Mail, Lock, ArrowRight, CheckCircle2, AlertCircle } from 'lucide-react';
import { apiService } from '../services/api';

export default function Login() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const [status, setStatus] = useState({
    loading: false,
    error: null,
    success: null,
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setStatus({ loading: true, error: null, success: null });

    try {
      const response = await apiService.login(formData.email, formData.password);

      setStatus({
        loading: false,
        error: null,
        success: 'Logged in successfully! Redirecting...',
      });

      // Role-based redirect if roles exist in user object
      const roles = response.user?.roles || [];
      const isAdmin = roles.some((r) => r.name === 'ROLE_ADMIN' || r.name === 'ADMIN');

      setTimeout(() => {
        if (isAdmin) {
          navigate('/admin');
        } else {
          navigate('/user');
        }
      }, 700);
    } catch (err) {
      setStatus({
        loading: false,
        error: err.message || 'Login failed. Please check credentials.',
        success: null,
      });
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        <div className="auth-header">
          <div className="auth-icon-badge">
            <LogIn size={26} />
          </div>
          <h2>Welcome Back</h2>
          <p>Please enter your email and password to log in</p>
        </div>

        {status.error && (
          <div className="alert alert-error">
            <AlertCircle size={18} />
            <span>{status.error}</span>
          </div>
        )}

        {status.success && (
          <div className="alert alert-success">
            <CheckCircle2 size={18} />
            <span>{status.success}</span>
          </div>
        )}

        <form onSubmit={handleSubmit} className="auth-form">
          <div className="form-group">
            <label htmlFor="email">Email Address</label>
            <div className="input-with-icon">
              <Mail size={18} className="input-icon" />
              <input
                id="email"
                name="email"
                type="email"
                required
                placeholder="name@example.com"
                value={formData.email}
                onChange={handleChange}
              />
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>
            <div className="input-with-icon">
              <Lock size={18} className="input-icon" />
              <input
                id="password"
                name="password"
                type="password"
                required
                placeholder="Enter your password"
                value={formData.password}
                onChange={handleChange}
              />
            </div>
          </div>

          <button
            type="submit"
            className="btn btn-primary btn-block"
            disabled={status.loading}
          >
            {status.loading ? (
              'Authenticating...'
            ) : (
              <>
                <span>Login</span>
                <ArrowRight size={18} />
              </>
            )}
          </button>
        </form>

        <div className="auth-footer">
          <p>
            Don't have an account?{' '}
            <Link to="/signup" className="auth-link">
              Sign up here
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
}
