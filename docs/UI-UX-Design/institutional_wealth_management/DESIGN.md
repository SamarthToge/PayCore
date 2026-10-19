---
name: Institutional Wealth Management
colors:
  surface: '#f7f9fb'
  surface-dim: '#d8dadc'
  surface-bright: '#f7f9fb'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f2f4f6'
  surface-container: '#eceef0'
  surface-container-high: '#e6e8ea'
  surface-container-highest: '#e0e3e5'
  on-surface: '#191c1e'
  on-surface-variant: '#3d4a42'
  inverse-surface: '#2d3133'
  inverse-on-surface: '#eff1f3'
  outline: '#6d7a72'
  outline-variant: '#bccac0'
  surface-tint: '#006c4a'
  primary: '#006948'
  on-primary: '#ffffff'
  primary-container: '#00855d'
  on-primary-container: '#f5fff7'
  inverse-primary: '#68dba9'
  secondary: '#565e74'
  on-secondary: '#ffffff'
  secondary-container: '#dae2fd'
  on-secondary-container: '#5c647a'
  tertiary: '#4d5d73'
  on-tertiary: '#ffffff'
  tertiary-container: '#66768d'
  on-tertiary-container: '#fdfcff'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#85f8c4'
  primary-fixed-dim: '#68dba9'
  on-primary-fixed: '#002114'
  on-primary-fixed-variant: '#005137'
  secondary-fixed: '#dae2fd'
  secondary-fixed-dim: '#bec6e0'
  on-secondary-fixed: '#131b2e'
  on-secondary-fixed-variant: '#3f465c'
  tertiary-fixed: '#d3e4fe'
  tertiary-fixed-dim: '#b7c8e1'
  on-tertiary-fixed: '#0b1c30'
  on-tertiary-fixed-variant: '#38485d'
  background: '#f7f9fb'
  on-background: '#191c1e'
  surface-variant: '#e0e3e5'
typography:
  headline-xl:
    fontFamily: Manrope
    fontSize: 3rem
    fontWeight: '700'
    lineHeight: 3.5rem
    letterSpacing: -0.03em
  headline-xl-mobile:
    fontFamily: Manrope
    fontSize: 2rem
    fontWeight: '700'
    lineHeight: 2.5rem
    letterSpacing: -0.025em
  headline-lg:
    fontFamily: Manrope
    fontSize: 2.25rem
    fontWeight: '600'
    lineHeight: 2.75rem
    letterSpacing: -0.025em
  headline-lg-mobile:
    fontFamily: Manrope
    fontSize: 1.75rem
    fontWeight: '600'
    lineHeight: 2.25rem
    letterSpacing: -0.02em
  headline-md:
    fontFamily: Manrope
    fontSize: 1.5rem
    fontWeight: '600'
    lineHeight: 2rem
    letterSpacing: -0.02em
  headline-sm:
    fontFamily: Manrope
    fontSize: 1.25rem
    fontWeight: '600'
    lineHeight: 1.75rem
    letterSpacing: -0.015em
  body-lg:
    fontFamily: Inter
    fontSize: 1.125rem
    fontWeight: '400'
    lineHeight: 1.75rem
    letterSpacing: -0.01em
  body-md:
    fontFamily: Inter
    fontSize: 1rem
    fontWeight: '400'
    lineHeight: 1.5rem
    letterSpacing: -0.005em
  body-sm:
    fontFamily: Inter
    fontSize: 0.875rem
    fontWeight: '400'
    lineHeight: 1.25rem
    letterSpacing: '0'
  label-lg:
    fontFamily: Inter
    fontSize: 0.875rem
    fontWeight: '600'
    lineHeight: 1.25rem
    letterSpacing: 0.01em
  label-md:
    fontFamily: Inter
    fontSize: 0.75rem
    fontWeight: '600'
    lineHeight: 1rem
    letterSpacing: 0.025em
  label-sm:
    fontFamily: Inter
    fontSize: 0.6875rem
    fontWeight: '500'
    lineHeight: 0.875rem
    letterSpacing: 0.04em
rounded:
  sm: 0.125rem
  DEFAULT: 0.25rem
  md: 0.375rem
  lg: 0.5rem
  xl: 0.75rem
  full: 9999px
spacing:
  gutter: 1.5rem
  gutter-sm: 1rem
  gutter-lg: 2rem
  margin: 2rem
  margin-mobile: 1rem
  margin-desktop: 3rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2.5rem
---

## Brand & Style

The design system establishes a high-trust, institutional-grade visual interface tailored for enterprise finance, wealth managers, and private banking clients. The visual character projects absolute clarity, stability, and operational efficiency through pristine light surfaces, meticulous typographic rhythm, and targeted emerald green interactions.

### Personality & Emotional Tenor
- **Institutional Rigor:** Surfaces and structures convey stability, audit-readiness, and mathematical precision without decorative excess.
- **Immediate Legibility:** High-contrast text hierarchies ensure critical financial figures, portfolio distributions, and transactional events can be digested instantly.
- **Disciplined Precision:** Visual density balances expansive whitespace with data compactness, avoiding visual clutter while retaining high utility.

### Style Attributes
Drawing from contemporary Swiss modernist principles and refined corporate utility, the aesthetic combines clean paper-white and slate foundations with subtle cool-gray outlines. Emerald green serves as the signature actionable accent and positive financial vector, maintaining deliberate contrast against neutral, subdued structural elements.

## Colors

The palette is engineered around an architectural hierarchy of structural neutrals, high-contrast dark values, and an authoritative emerald accent.

### Color Palette Strategy
- **Primary Accent (`#059669`):** Represents verified states, primary calls-to-action, net asset growth, and positive transactional telemetry. It is applied selectively to command focus without overwhelming the screen.
- **Deep Slate Grounding (`#0f172a`):** Serves as the principal typography color, primary container headers, and maximum-contrast navigational anchors.
- **Mid Slate Utility (`#64748b`):** Delivers secondary metadata, table headers, column labels, disabled states, and auxiliary metrics.
- **Neutral Surface Foundation (`#f8fafc`):** Establishes the canvas backdrop, with true white (`#ffffff`) reserved for elevated interactive tiles, floating panels, and data tables.
- **Borders & Partitions (`#e2e8f0` / `#cbd5e1`):** Subtle, crisp dividers that preserve optical boundaries without harsh containment.

## Typography

The typographic hierarchy pairs the structured geometric elegance of **Manrope** for primary statements and metrics with the utilitarian legibility of **Inter** for data grids, transactional manifests, and operational copy.

### Architectural Rules
- **Headline Rendering:** Set Manrope with slightly tightened letter-spacing (`-0.015em` to `-0.03em`) to anchor dashboards and major portfolio totals with solid structural mass.
- **Tabular Numerics:** For tables, ledgers, currency figures, and time stamps, always enforce tabular numerals (`font-feature-settings: "tnum" 1`) to guarantee perfect vertical column alignment.
- **Metadata Disciplines:** Micro labels and column headers use `label-md` or `label-sm` with upper or title casing, slightly relaxed tracking (`0.025em` to `0.04em`), and muted slate weights to distinguish metadata from live financial metrics.

## Layout & Spacing

A structured 12-column layout coordinates data feeds, portfolio charts, and asset breakdowns across varied viewport formats.

### Grid & Layout Strategy
- **Desktop (12 Columns):** Employs standard 1.5rem (`24px`) gutters within a constrained layout container maximum of 1440px. Margin buffers expand to 3rem on wide displays to maintain optical framing.
- **Tablet (8 Columns):** Adjusts gutters to 1rem (`16px`) with 1.5rem exterior margins; tables adopt horizontal scroll wrappers, and secondary telemetry collapses below primary metrics.
- **Mobile (4 Columns):** Fluid single-column stacks with 1rem canvas margin buffers. Side-by-side metric pairs retain a strict 0.5rem gap.

### Internal Spacing Cadence
- Use `space-xs` (4px) and `space-sm` (8px) for tightly coupled units such as currency symbols, badge icons, and input helper text.
- Use `space-md` (16px) for interior card padding, segmented controls, and standard stack gaps.
- Use `space-lg` (24px) for major card interiors, table container padding, and vertical section transitions.
- Use `space-xl` (40px) to separate independent functional modules on high-level dashboard overviews.

## Elevation & Depth

Visual hierarchy leverages a hybrid approach: crisp architectural outlines paired with muted, highly-diffused ambient drop shadows. Surfaces remain lightweight and razor-sharp, maintaining the institutional character.

### Surface Tiers
- **Canvas Base:** `#f8fafc` — The ground plane across all main views.
- **Resting Panels & Cards:** `#ffffff` bordered by 1px solid `#e2e8f0`, backed by an ambient shadow: `0 1px 3px 0 rgba(15, 23, 42, 0.04), 0 1px 2px -1px rgba(15, 23, 42, 0.02)`.
- **Interactive Hover & Elevated Cards:** Retain the `#e2e8f0` border, shifting to `0 4px 12px -2px rgba(15, 23, 42, 0.06), 0 2px 6px -2px rgba(15, 23, 42, 0.03)`.
- **Flyouts, Dropdowns & Action Menus:** Floating `#ffffff` layers bordered by `#cbd5e1` with a deeper ambient blur: `0 10px 25px -5px rgba(15, 23, 42, 0.08), 0 8px 10px -6px rgba(15, 23, 42, 0.04)`.
- **Modal Modals & Sheets:** Elevated above a backdrop overlay (`rgba(15, 23, 42, 0.4)` with 4px backdrop blur), framed with a distinct 1px border and deep elevation: `0 20px 30px -10px rgba(15, 23, 42, 0.12)`.

## Shapes

The design system incorporates a disciplined, compact corner radius (`roundedness: 1`), projecting an institutional, engineered sensibility.

### Boundary Radius Specifications
- **Base Geometry (`0.25rem` / `4px`):** Standard inputs, small badges, buttons, tooltips, segmented switches, and inline chips.
- **Card & Panel Outer (`rounded-lg: 0.5rem` / `8px`):** Structural dashboard cards, summary panels, transaction lists, and table wrappers.
- **Overlay Radius (`rounded-xl: 0.75rem` / `12px`):** Full-screen dialogs, institutional slide-out trays, and notification toasts.
- **Exceptions:** Status pill indicators and circular avatar components may utilize full circular radii (`9999px`) to visually separate them from structural containers.

## Components

### Buttons
- **Primary:** Solid `#059669` emerald fill with `#ffffff` text, 4px border radius, 0.5rem vertical by 1rem horizontal padding. Hover elevates brightness to `#047857`; active state transitions to `#065f46`.
- **Secondary:** Surface `#ffffff` with 1px border in `#e2e8f0`, text in `#0f172a`. Hover transitions border to `#cbd5e1` and background to `#f8fafc`.
- **Tertiary / Ghost:** Transparent background, `#64748b` text, shifting to `#0f172a` text and `#f1f5f9` fill on hover.

### Form Inputs & Selects
- Height: 40px standard (32px compact for dense financial grids).
- Background: `#ffffff` with 1px `#e2e8f0` border.
- Text: `#0f172a` with placeholder text in `#94a3b8`.
- Focus State: 1px border in `#059669` paired with a 2px outer glow in `rgba(5, 150, 105, 0.15)`.

### Cards & Summary Tiles
- Background: `#ffffff` with a continuous 1px `#e2e8f0` stroke and subtle resting shadow.
- Interior layout: Divided into a distinct header zone (title + contextual indicator) and a dominant metric zone featuring tabular figures, accompanied by micro-scale delta indicators (e.g., +2.45% in `#059669`).

### Data Tables & Ledgers
- Structure: Header row uses `#f8fafc` background with 1px border-bottom in `#e2e8f0`, containing uppercase `label-md` text in `#64748b`.
- Rows: `#ffffff` background with 1px `#f1f5f9` horizontal interior dividers. Alternating row highlights are omitted in favor of a subtle `#f8fafc` background fill on hover.

### Checkboxes & Segmented Radio Buttons
- Checkbox: 16px square, 3px border radius, 1.5px `#cbd5e1` border. Checked state fills with `#059669` displaying a crisp white vector checkmark.
- Radio Control: 16px circular boundary; selected state renders a solid 6px `#059669` center pip.

### Chips & Badges
- Performance / Status Chip: 20px height, 4px corner radius, composed of `rgba(5, 150, 105, 0.1)` emerald tint ground with `#047857` text for positive movement; `rgba(239, 68, 68, 0.1)` with `#b91c1c` text for drawdowns.