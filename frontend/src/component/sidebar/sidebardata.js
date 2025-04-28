import React from "react";
import HomeIcon from '@mui/icons-material/Home';
import SetMealIcon from '@mui/icons-material/SetMeal';
import WarehouseIcon from '@mui/icons-material/Warehouse';


export const SidebarData = [
  {
    title: "Home",

    icon: <HomeIcon />,

    link: "/home",
  },

  {
    title: "Akwaria",

    icon: <SetMealIcon />,

    link: "/aquariumlist",
  },

  {
    title: "Magazyn",

    icon: <WarehouseIcon />,

    link: "/warehouse",
  },
];
