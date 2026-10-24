import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { UserPlus, Mail, Lock, User, ShieldCheck, ArrowRight, CheckCircle2, AlertCircle } from 'lucide-react';
import { apiService } from '../services/api';

export default function Signup() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    role: 'USER',
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

    if (formData.password !== formData.confirmPassword) {
      setStatus({
        loading: false,
        error: 'Passwords do not match. Please verify.',
        success: null,
      });
      return;
    }

    try {
      await apiService.signup({
        name: formData.name,
        email: formData.email,
        password: formData.password,
        roles: [{ name: formData.role === 'ADMIN' ? 'ROLE_ADMIN' : 'ROLE_USER' }],
      });

      setStatus({
        loading: false,
        error: null,
        success: 'Registration successful! Redirecting to login...',
      });

      setTimeout(() => {
        navigate('/login');
      }, 1200);
    } catch (err) {
      setStatus({
        loading: false,
        error: err.message || 'Registration failed. Please try again.',
        success: null,
      });
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        <div className="auth-header">
          <div className="auth-icon-badge signup-badge">
            <UserPlus size={26} />
          </div>
          <h2>Create Account</h2>
          <p>Sign up to get started with CollabBoard</p>
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
            <label htmlFor="name">Full Name</label>
            <div className="input-with-icon">
              <User size={18} className="input-icon" />
              <input
                id="name"
                name="name"
                type="text"
                required
                placeholder="John Doe"
                value={formData.name}
                onChange={handleChange}
              />
            </div>
          </div>

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
                placeholder="Create a password"
                value={formData.password}
                onChange={handleChange}
              />
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="confirmPassword">Confirm Password</label>
            <div className="input-with-icon">
              <Lock size={18} className="input-icon" />
              <input
                id="confirmPassword"
                name="confirmPassword"
                type="password"
                required
                placeholder="Confirm your password"
                value={formData.confirmPassword}
                onChange={handleChange}
              />
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="role">Assign Role</label>
            <div className="input-with-icon">
              <ShieldCheck size={18} className="input-icon" />
              <select
                id="role"
                name="role"
                value={formData.role}
                onChange={handleChange}
                className="select-input select-with-icon"
              >
                <option value="USER">User (Standard Access)</option>
                <option value="ADMIN">Admin (Administrative Access)</option>
              </select>
            </div>
          </div>

          <button
            type="submit"
            className="btn btn-primary btn-block"
            disabled={status.loading}
          >
            {status.loading ? (
              'Creating account...'
            ) : (
              <>
                <span>Sign Up</span>
                <ArrowRight size={18} />
              </>
            )}
          </button>
        </form>

        <div className="auth-footer">
          <p>
            Already have an account?{' '}
            <Link to="/login" className="auth-link">
              Log in here
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
}
