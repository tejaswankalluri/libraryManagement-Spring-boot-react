import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Home } from "./pages/Home";
import { Members } from "./pages/Members";
function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/members" element={<Members />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
