import React from "react";
import "./Home.css"

function Home() {
  return (
    <div>
      <h1>Witaj na FeedFishCalc</h1>
      <h2>System zarządzania sprzętem komputerowym</h2>
      <p>
        Administrator ma możliwość rejestrowania urządzeń, przypisywania ich do
        użytkowników oraz prowadzenia stanu sprzętu.
      </p>
      <p>
        Użytkownicy mogą przeglądać listę przypisanego sprzętu, zgłaszać awarie
        i wnioskować o wymianę urządzeń.
      </p>
      <p>
        Każda operacja wydania i zwrotu sprzętu jest rejestrowana, co pozwala na
        pełną historię użytkowania zasobów IT.
      </p>

      <h2>System obliczania zapotrzebowania na karmę dla ryb</h2>
      <p>
        Na podstawie wagi ryby i dostępnych karm system oblicza dzienne
        zapotrzebowanie na karmę.
      </p>
      <p>System wybiera karmę o najkrótszym terminie przydatności.</p>

      <h2>Rejestracja i logowanie</h2>
      <p>
        Aby uzyskać dostęp do większej ilości funkcji, wymagana jest rejestracja
        i logowanie.
      </p>
    </div>
  );
}

export default Home;
