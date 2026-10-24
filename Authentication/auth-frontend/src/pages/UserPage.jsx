import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { User, LogOut, Mail, Calendar, Shield } from 'lucide-react';
import { apiService } from '../services/api';

export default function UserPage() {
  const navigate = useNavigate();
  const [currentUser, setCurrentUser] = useState(null);

  useEffect(() => {
    const saved = localStorage.getItem('currentUser');
    if (saved) {
      try {
        setCurrentUser(JSON.parse(saved));
      } catch (e) {
        console.error('Error parsing user', e);
      }
    } else {
      navigate('/login');
    }
  }, [navigate]);

  const handleLogout = async () => {
    await apiService.logout();
    navigate('/login');
  };

  if (!currentUser) return null;

  return (
    <div className="dashboard-container">
      <div className="welcome-banner user-banner">
        <div className="banner-content">
          <div className="badge-pill user-pill">
            <User size={14} />
            <span>User Portal</span>
          </div>
          <h1 className="greeting-text">Hello, {currentUser.name || currentUser.email || 'User'}! 👋</h1>
          <p className="banner-subtitle">
            Welcome to your personal dashboard. Your JWT session is active and verified by the backend.
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
          <User size={20} />
          Profile Details
        </h3>
        <div className="info-grid">
          <div className="info-item">
            <div className="info-label">Full Name</div>
            <div className="info-val">{currentUser.name || 'Not provided'}</div>
          </div>

          <div className="info-item">
            <div className="info-label">Email</div>
            <div className="info-val">{currentUser.email || 'N/A'}</div>
          </div>

          <div className="info-item">
            <div className="info-label">User ID</div>
            <div className="info-val" style={{ fontSize: '0.85rem' }}>{currentUser.id || 'N/A'}</div>
          </div>

          <div className="info-item">
            <div className="info-label">Assigned Roles</div>
            <div className="info-val">
              {currentUser.roles && currentUser.roles.length > 0
                ? currentUser.roles.map((r) => r.name).join(', ')
                : 'ROLE_USER'}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}