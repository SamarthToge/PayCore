import { Link } from 'react-router-dom';
import { Sparkles, Shield, KeyRound, UserCheck, ArrowRight } from 'lucide-react';

export default function Home() {
  return (
    <div className="home-container">
      <div className="home-hero">
        <div className="hero-badge">
          <Sparkles size={16} />
          <span>Full Stack Authentication</span>
        </div>
        <h1 className="hero-title">Welcome to CollabBoard</h1>
        <p className="hero-description">
          A secure, modern React application powered by Spring Boot, Spring Security,
          JWT tokens, and HttpOnly refresh cookies.
        </p>

        <div style={{ marginTop: '1.75rem', display: 'flex', gap: '1rem', justifyContent: 'center' }}>
          <Link to="/login" className="btn btn-primary">
            <span>Go to Login</span>
            <ArrowRight size={16} />
          </Link>
          <Link to="/signup" className="btn btn-secondary">
            <span>Create Account</span>
          </Link>
        </div>
      </div>

      <div className="features-grid">
        <div className="feature-card">
          <div className="feature-icon-wrapper">
            <KeyRound size={22} />
          </div>
          <h3>JWT & Cookie Security</h3>
          <p>
            Stateless authentication using access tokens and rotating HttpOnly refresh tokens protected against XSS and CSRF attacks.
          </p>
        </div>

        <div className="feature-card">
          <div className="feature-icon-wrapper">
            <Shield size={22} />
          </div>
          <h3>Role-Based Access</h3>
          <p>
            Granular permissions distinguishing standard users from administrators with dedicated, protected dashboards.
          </p>
        </div>

        <div className="feature-card">
          <div className="feature-icon-wrapper">
            <UserCheck size={22} />
          </div>
          <h3>Spring Security Filter</h3>
          <p>
            Automated token inspection with custom filters verifying claims, expiration timestamps, and user states on every request.
          </p>
        </div>
      </div>
    </div>
  );
}