---
name: Vanguard Obsidian
colors:
  surface: '#0b1326'
  surface-dim: '#0b1326'
  surface-bright: '#31394d'
  surface-container-lowest: '#060e20'
  surface-container-low: '#131b2e'
  surface-container: '#171f33'
  surface-container-high: '#222a3d'
  surface-container-highest: '#2d3449'
  on-surface: '#dae2fd'
  on-surface-variant: '#bbcabf'
  inverse-surface: '#dae2fd'
  inverse-on-surface: '#283044'
  outline: '#86948a'
  outline-variant: '#3c4a42'
  surface-tint: '#4edea3'
  primary: '#4edea3'
  on-primary: '#003824'
  primary-container: '#10b981'
  on-primary-container: '#00422b'
  inverse-primary: '#006c49'
  secondary: '#c0c1ff'
  on-secondary: '#1000a9'
  secondary-container: '#3131c0'
  on-secondary-container: '#b0b2ff'
  tertiary: '#4cd7f6'
  on-tertiary: '#003640'
  tertiary-container: '#00b2d0'
  on-tertiary-container: '#003f4b'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#6ffbbe'
  primary-fixed-dim: '#4edea3'
  on-primary-fixed: '#002113'
  on-primary-fixed-variant: '#005236'
  secondary-fixed: '#e1e0ff'
  secondary-fixed-dim: '#c0c1ff'
  on-secondary-fixed: '#07006c'
  on-secondary-fixed-variant: '#2f2ebe'
  tertiary-fixed: '#acedff'
  tertiary-fixed-dim: '#4cd7f6'
  on-tertiary-fixed: '#001f26'
  on-tertiary-fixed-variant: '#004e5c'
  background: '#0b1326'
  on-background: '#dae2fd'
  surface-variant: '#2d3449'
typography:
  display:
    fontFamily: Inter
    fontSize: 48px
    fontWeight: '600'
    lineHeight: 56px
    letterSpacing: -0.02em
  display-mobile:
    fontFamily: Inter
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Inter
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
    letterSpacing: -0.02em
  headline-lg-mobile:
    fontFamily: Inter
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
    letterSpacing: -0.01em
  headline-md:
    fontFamily: Inter
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
    letterSpacing: -0.01em
  headline-sm:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 26px
    letterSpacing: -0.005em
  body-lg:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
    letterSpacing: 0em
  body-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
    letterSpacing: 0em
  body-sm:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '400'
    lineHeight: 16px
    letterSpacing: 0.005em
  label-md:
    fontFamily: Inter
    fontSize: 13px
    fontWeight: '500'
    lineHeight: 18px
    letterSpacing: 0.01em
  label-sm:
    fontFamily: Inter
    fontSize: 11px
    fontWeight: '600'
    lineHeight: 14px
    letterSpacing: 0.04em
  metric-headline:
    fontFamily: Inter
    fontSize: 36px
    fontWeight: '700'
    lineHeight: 44px
    letterSpacing: -0.03em
  metric-subhead:
    fontFamily: Inter
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
    letterSpacing: -0.01em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1.5rem
  gutter-mobile: 0.75rem
  margin: 2rem
  margin-mobile: 1rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2rem
---

## Brand & Style

This design system targets high-net-worth individuals, modern retail investors, and quantitative asset managers who require institutional-grade precision paired with contemporary digital-native ergonomics. The aesthetic balances deep, quiet wealth with active, real-time analytics.

The visual direction merges **Modern Corporate Neo-Banking** with subtle **Precision Glass-Surface layering**:
- **Atmosphere:** Dark, focused, and authoritative. Deep charcoal canvases eliminate eye fatigue during extensive analytical sessions while conveying stability and cryptographic security.
- **Tone:** Objective, crisp, transparent, and measured. Typography and metric displays prioritize immediate scan-speed and total absence of ambiguity.
- **Accents:** Emerald `#10B981` acts as the primary signifier of liquidity, compounding growth, and confirmed execution, balanced against controlled analytic blue-indigos and risk-warning ambers.

## Colors

The palette is engineered for high-contrast legibility across dark backgrounds while preserving strict semantic categorization for multi-asset telemetry.

### Core Semantic Mapping
- **Primary (`#10B981`):** Represents capital generation, yield, available liquidity, and affirmative system actions.
- **Secondary (`#6366F1`):** Applied to telemetry, portfolio weights, synthetic instruments, and interactive navigation rails.
- **Tertiary (`#06B6D4`):** Real-time execution scans, active filters, streaming trade logs, and algorithmic indicators.
- **Warning / Debt (`#F59E0B`):** Liabilities, pending settlements, margin calls, and amortized repayment alerts.
- **Error / Outflow (`#EF4444`):** Direct losses, failed transactions, systemic risk warnings, and liquidation thresholds.

### Surface Architecture
- **Base Canvas (`#090D16`):** The foundational substrate behind all layout modules.
- **Surface Level 1 (`#0F172A`):** Standard container background for balance panels, transaction feeds, and data tables.
- **Surface Level 2 (`#1E293B`):** Elevated modules, floating context toolbars, dropdown popovers, and interactive modal shells.
- **Border Subtle (`rgba(255, 255, 255, 0.08)`): Base perimeter delimiter for all modular cards.
- **Border Active Glow (`rgba(16, 185, 129, 0.25)`): Active state accent outline for focused inputs and selected asset cards.

## Typography

Typography relies entirely on the systematic clarity of `Inter` to deliver absolute numeric legibility and tight horizontal tracking suitable for dense financial screens.

- **Tabular Figures:** All metrics, trade executions, order book rows, and currency fields must use CSS `font-feature-settings: "tnum" 1, "cv05" 1` to guarantee vertical column alignment and disambiguation of glyphs.
- **Hierarchy:** Primary net-worth readouts utilize `metric-headline` with tight negative tracking (`-0.03em`) to anchor dashboards. Section indicators rely on `label-sm` rendered in uppercase styling with widened tracking (`0.04em`) for clear functional zoning.
- **Responsive Handling:** Display values scale automatically between desktop and mobile break intervals to prevent layout breakage across narrow screen viewports.

## Layout & Spacing

The structural framework is built on a responsive 12-column grid with a strict 4px base spatial unit.

- **Desktop (1280px and wider):** 12 columns, 24px gutters (`gutter`), 32px canvas borders (`margin`). Max layout containment is capped at 1600px for expansive multi-monitor setups.
- **Tablet (768px – 1279px):** 8 columns, 16px gutters, 24px margins. Two-column metric groups collapse into stacked horizontal segments.
- **Mobile (Below 768px):** 4 columns, 12px gutters (`gutter-mobile`), 16px margins (`margin-mobile`). Analytical cards and telemetry lists expand to full canvas width.
- **Interior Component Rhythm:** Inner-card padding strictly utilizes `space-md` (16px) for compact widgets or `space-lg` (24px) for prominent hero overview blocks. Data lists follow `space-sm` (8px) row separators to maintain dense information utility.

## Elevation & Depth

Visual hierarchy uses a refined hybrid of tonal tiering, translucent boundary lines, and controlled ambient illumination. Deep dark UIs fail when given heavy black drop shadows; instead, this system utilizes chromatic luminescence and low-contrast borders.

- **Ground Level (Canvas):** Pure `#090D16`. Flat, non-interactive, zero elevation.
- **Level 1 (Structural Cards & Modules):** Surface `#0F172A` with a 1px perimeter border of `rgba(255, 255, 255, 0.08)`. No directional shadow.
- **Level 2 (Hovered Cards & Interactive Controls):** Surface `#1E293B`, bordered by `rgba(255, 255, 255, 0.14)`, supported by an ambient drop shadow: `0 8px 24px -4px rgba(0, 0, 0, 0.45)`.
- **Level 3 (Modals, Overlays, Floating Drawers):** Backdrop filter `blur(16px)` combined with surface `rgba(15, 23, 42, 0.85)`. Border elevated to `rgba(255, 255, 255, 0.18)` and an ambient shadow: `0 20px 48px -8px rgba(0, 0, 0, 0.70)`.
- **Focus & Semantic Radiance:** Interactive states project an inner or perimeter glow:
  - Primary Accent Glow: `0 0 0 1px #10B981, 0 0 16px -2px rgba(16, 185, 129, 0.25)`
  - Alert/Margin Glow: `0 0 0 1px #F59E0B, 0 0 16px -2px rgba(245, 158, 11, 0.20)`

## Shapes

The design uses standard rounded geometry (`roundedness: 2`) to maintain a serious, institutional character while steering clear of cold, hyper-brutalist angularity or overly playful toy-like pill designs.

- **Base Radius (0.5rem / 8px):** Applied to standard buttons, input fields, dropdown trigger buttons, tab items, and inner nested badges.
- **Large Radius (1.0rem / 16px):** Standard for main content cards, telemetry panels, modal viewports, and table containers.
- **Extra-Large Radius (1.5rem / 24px):** Reserved for large visual containers, persistent dashboard shells, or multi-metric summary wrappers.
- **Pill Exception (9999px):** Applied solely to financial status pills, operational state chips (e.g., "LIVE", "SETTLED"), and micro percentage tags.

## Components

### Buttons
- **Primary:** Background `#10B981`, foreground `#042F2E` (or `#FFFFFF` depending on contrast check), font `label-md`. Semi-bold weight, 8px corner radius. On hover, background shifts to `#059669` with an emerald glow.
- **Secondary:** Surface `#1E293B`, border `1px solid rgba(255, 255, 255, 0.12)`, text `#F8FAFC`. Hover brings border to `rgba(255, 255, 255, 0.25)` and background to `#334155`.
- **Ghost/Tertiary:** Transparent fill, text `#94A3B8`. Hover introduces `rgba(255, 255, 255, 0.05)`.

### Cards & Data Modules
- Built on Surface Level 1 (`#0F172A`) with a subtle 1px border (`rgba(255, 255, 255, 0.08)`). Header sections feature a distinct bottom border separator (`rgba(255, 255, 255, 0.05)`), housing the card title in `headline-sm` alongside contextual controls or timestamp indicators.

### Metric Indicators & Financial Badges
- **Positive Delta:** Pill shape, background `rgba(16, 185, 129, 0.12)`, text `#34D399`, border `1px solid rgba(16, 185, 129, 0.25)`, icon prefixed with an upward arrow.
- **Negative Delta:** Pill shape, background `rgba(239, 68, 68, 0.12)`, text `#F87171`, border `1px solid rgba(239, 68, 68, 0.25)`, icon prefixed with a downward arrow.
- **Debt / Warning:** Pill shape, background `rgba(245, 158, 11, 0.12)`, text `#FBBF24`, border `1px solid rgba(245, 158, 11, 0.25)`.

### Input Fields & Selectors
- Height 42px. Surface `#090D16`, border `1px solid rgba(255, 255, 255, 0.12)`, radius 8px, typography `body-md` in `#F8FAFC`. Placeholder colored `#64748B`.
- Focus state switches border to `#10B981` with the primary accent glow outline.

### Checkboxes & Segmented Controls
- **Checkboxes:** 18x18px box, radius 4px, border `rgba(255, 255, 255, 0.2)`. Checked state transitions to `#10B981` with a dark `#042F2E` checkmark glyph.
- **Segmented Control:** Enclosed container `#090D16` with 8px radius. Active segment translates with an elevated `#1E293B` tile, 6px radius, bordered by `rgba(255, 255, 255, 0.10)`.

### Lists & Telemetry Tables
- Row zebra striping is replaced by transparent rows separated by `1px solid rgba(255, 255, 255, 0.04)`.
- Row hover triggers an immediate shift to `rgba(255, 255, 255, 0.02)`. Numerical table columns must enforce right-alignment with tabular lining font features enabled.