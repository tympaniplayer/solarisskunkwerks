/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package states;

public class stCVHoverSH implements ifCombatVehicle {
    // Hovercraft state
    public int GetSuspensionFactor( int Tonnage ) {
        return 235 + (int)Math.ceil(((Tonnage - 50) / 25.0)) * 45;
    }

    public int GetMinTonnage() {
        return 51;
    }
    
    public int GetMaxTonnage() {
        return 100;
    }

    public float GetMinEngineWeight( int Tonnage ) {
        return ((int) ( Math.ceil( Tonnage * 0.2f * 2 ))) * 0.5f;
    }

    public boolean RequiresLiftEquipment() {
        return true;
    }

    public float GetLiftEquipmentCostMultiplier() {
        return 20000.0f;
    }

    public boolean CanBeTrailer() {
        return false;
    }

    public String GetMotiveLookupName() {
        return "Hovercraft";
    }

    public boolean CanUseJumpMP() {
        return true;
    }

    public boolean CanUseTurret() {
        return true;
    }

    public boolean IsVTOL() {
        return false;
    }

    public boolean CanBeDuneBuggy() {
        return false;
    }

    public boolean CanUseFlotationHull() {
        return true;
    }

    public boolean CanUseArmoredMotiveSystem() {
        return true;
    }

    public boolean CanUseAmphibious() {
        return false;
    }

    public boolean CanUseMinesweeper() {
        return false;
    }
    
    public boolean CanUseEnviroSealing() {
        return true;
    }

    public int GetCostMultiplier() {
        return 50;
    }
    
    public double GetDefensiveMultiplier() {
        return 0.7;
    }
    public boolean IsSuperHeavy() {
        return true;
    }
    public String GetBFMotiveType() {
        return "h";
    }
}
