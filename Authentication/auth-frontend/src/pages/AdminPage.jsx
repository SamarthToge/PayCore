import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Shield, LogOut, CheckCircle2 } from 'lucide-react';
import { apiService } from '../services/api';

export default function AdminPage() {
  const navigate = useNavigate();
  const [currentAdmin, setCurrentAdmin] = useState(null);

  useEffect(() => {
    const saved = localStorage.getItem('currentUser');
    if (saved) {
      try {
        const user = JSON.parse(saved);
        setCurrentAdmin(user);
      } catch (e) {
        console.error('Error parsing admin info', e);
      }
    } else {
      navigate('/login');
    }
  }, [navigate]);

  const handleLogout = async () => {
    await apiService.logout();
    navigate('/login');
  };

  if (!currentAdmin) return null;

  return (
    <div className="dashboard-container">
      <div className="welcome-banner admin-banner">
        <div className="banner-content">
          <div className="badge-pill admin-pill">
            <Shield size={14} />
            <span>Administrator Control Center</span>
          </div>
          <h1 className="greeting-text">Hello, {currentAdmin.name || currentAdmin.email || 'Admin'}! 🛡️</h1>
          <p className="banner-subtitle">
            You are authenticated with Administrative access. Security filters and JWT validation are active.
          </p>
        </div>

        <div className="banner-actions">
          <button onClick={handleLogout} className="btn btn-outline-white">
            <LogOut size={16} />
            <span>Logout</span>
          </button>
        </div>
      </div>

      <div className="dashboard-card">
        <h3>
          <Shield size={20} />
          Admin Session Overview
        </h3>
        <div className="info-grid">
          <div className="info-item">
            <div className="info-label">Admin Name</div>
            <div className="info-val">{currentAdmin.name || 'Admin'}</div>
          </div>
          <div className="info-item">
            <div className="info-label">Email Account</div>
            <div className="info-val">{currentAdmin.email || 'N/A'}</div>
          </div>
          <div className="info-item">
            <div className="info-label">Security Privilege</div>
            <div className="info-val" style={{ color: '#4f46e5' }}>Full Admin Access</div>
          </div>
          <div className="info-item">
            <div className="info-label">System Status</div>
            <div className="info-val" style={{ color: '#10b981', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
              <CheckCircle2 size={16} /> Backend Connected
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}