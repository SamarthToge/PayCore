import { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { LayoutDashboard, LogIn, UserPlus, Shield, User, Sparkles, LogOut } from 'lucide-react';
import { apiService } from '../services/api';

export default function Navbar() {
  const location = useLocation();
  const navigate = useNavigate();
  const [user, setUser] = useState(null);

  useEffect(() => {
    const saved = localStorage.getItem('currentUser');
    if (saved) {
      try {
        setUser(JSON.parse(saved));
      } catch {
        setUser(null);
      }
    } else {
      setUser(null);
    }
  }, [location.pathname]);

  const isActive = (path) => location.pathname === path;

  const handleLogout = async () => {
    await apiService.logout();
    setUser(null);
    navigate('/login');
  };

  return (
    <header className="navbar">
      <div className="navbar-container">
        <Link to="/" className="navbar-brand">
          <div className="brand-icon">
            <Sparkles size={20} />
          </div>
          <span className="brand-name">CollabBoard</span>
        </Link>

        <nav className="navbar-links">
          <Link to="/" className={`nav-link ${isActive('/') ? 'active' : ''}`}>
            <LayoutDashboard size={16} />
            <span>Home</span>
          </Link>

          {!user ? (
            <>
              <Link to="/login" className={`nav-link ${isActive('/login') ? 'active' : ''}`}>
                <LogIn size={16} />
                <span>Login</span>
              </Link>

              <Link to="/signup" className={`nav-link ${isActive('/signup') ? 'active' : ''}`}>
                <UserPlus size={16} />
                <span>Sign Up</span>
              </Link>
            </>
          ) : (
            <>
              <Link to="/user" className={`nav-link ${isActive('/user') ? 'active' : ''}`}>
                <User size={16} />
                <span>Dashboard</span>
              </Link>

              <Link to="/admin" className={`nav-link ${isActive('/admin') ? 'active' : ''}`}>
                <Shield size={16} />
                <span>Admin</span>
              </Link>

              <button
                onClick={handleLogout}
                className="btn btn-secondary"
                style={{ padding: '0.4rem 0.85rem', fontSize: '0.85rem' }}
              >
                <LogOut size={14} />
                <span>Logout</span>
              </button>
            </>
          )}
        </nav>
      </div>
    </header>
  );
}
