import { Box, Typography } from "@mui/material";
import { useState, useEffect } from "react";
import DirectionsCarIcon from '@mui/icons-material/DirectionsCar';
import PersonIcon from '@mui/icons-material/Person';
import Ride from "../models/Ride";
import Position from "../models/Position";

export default function FollowRide() {
    const [ride, setRide] = useState<Ride | null>(null);
    const [carPosition, setCarPosition] = useState<Position>({ x: "0", y: "0" });
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        
        const intervalId = setInterval(() => {
            handleUpdateRide();
        }, 2500);

        return () => clearInterval(intervalId);
    });

    const handleUpdateRide = async () => {
        try {
            await fetch("https://uaeyswgs70.execute-api.us-east-1.amazonaws.com/prod/ride", {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(carPosition),
            }).then(response => {
                const data: Promise<Ride> = response.json()
                data.then(ride => {
                    setCarPosition(ride.driver.position);
                    setRide(ride);
                })
            });
            
            
        } catch (error) {
            console.error("Error updating ride:", error);
        } finally {
            setLoading(false);
        }
    }

    if (loading) {
        return (
            <Box sx={{ width: '100%', height: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center'}}>
                <Typography>Loading...</Typography>
            </Box>
        );
    }

    if (!ride) {
        return (
            <Box sx={{ width: '100%', height: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center'}}>
                <Typography>No ride data available...</Typography>
            </Box>
        );;
    }

    const mapSize = 400;
    const positionX = (parseInt(carPosition.x) / 40) * mapSize; 
    const positionY = (parseInt(carPosition.y) / 40) * mapSize;

    const destinationX = (parseInt(ride.destination.x) / 40) * mapSize;
    const destinationY = (parseInt(ride.destination.y) / 40) * mapSize;

    return (
        <Box sx={{ width: '100%', height: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center'}}>
            <Box sx={{ position: 'relative', width: mapSize, height: mapSize, border: '1px solid #ccc', backgroundColor: '#f0f0f0' }}>
                <PersonIcon sx={{ position: 'absolute', left: destinationX, top: destinationY, fontSize: 40, color: 'black' }} />
                <DirectionsCarIcon sx={{ position: 'absolute', left: positionX, top: positionY, fontSize: 40, color: 'blue' }} />
            </Box>

            {carPosition.x} {carPosition.y}
        </Box>
    );
}
