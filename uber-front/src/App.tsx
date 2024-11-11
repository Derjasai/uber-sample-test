import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import { FinanceRoutes, financeRoutesSpecification } from './Routes';
import StartRide from './components/StartRide';
import FollowRide from './components/FollowRide';

function App(): JSX.Element {


  return (
    <Router>
        <Routes>
          <Route path={financeRoutesSpecification[FinanceRoutes.START_RIDE].reactRouterPath} element={<StartRide />} />
          <Route path={financeRoutesSpecification[FinanceRoutes.FOLLOW_RIDE].reactRouterPath} element={<FollowRide />} />
        </Routes>
    </Router>
  );
}

export default App;
