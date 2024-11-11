import { Box, Button, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { FinanceRoutes, financeRoutesSpecification } from "../Routes";

export default function StartRide() {
    
    const navigate = useNavigate();

    const handleContinueToTrackYourRide = () => {
        navigate(financeRoutesSpecification[FinanceRoutes.FOLLOW_RIDE].reactRouterPath);
    }

    return (
        <Box sx={{ width: '100%', height: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center', flexDirection: 'column'}}>
            <Typography sx={{mb: 5}}>TU VIAJE FUE ACEPTADO</Typography>
            <Button variant="contained" onClick={handleContinueToTrackYourRide}>
                VER SEGUIMIENTO DE TU VIAJE
            </Button>
        </Box>
      );
}
