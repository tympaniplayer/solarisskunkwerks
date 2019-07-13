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

import components.MechArmor;
import components.AvailableCode;
import components.LocationIndex;
import components.MechModifier;
import components.ifMechLoadout;

public class stArmorIN implements ifArmor, ifState {
    boolean locked = false;
    private final static AvailableCode AC = new AvailableCode( AvailableCode.TECH_BOTH );

    public stArmorIN() {
        AC.SetISCodes( 'C', 'B', 'C', 'B' );
        AC.SetISDates( 0, 0, false, 2439, 0, 0, false, false );
        AC.SetISFactions( "", "", "TH", "" );
        AC.SetCLCodes( 'C', 'X', 'B', 'B' );
        AC.SetCLDates( 0, 0, false, 2439, 0, 0, false, false );
        AC.SetCLFactions( "", "", "TH", "" );
        AC.SetRulesLevels( AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_ADVANCED, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_TOURNAMENT );
    }

    public String ActualName() {
        return "Industrial Armor";
    }

    public String CritName() {
        return "Industrial";
    }

    public String LookupName() {
        return "Industrial Armor";
    }

    public String ChatName() {
        return "Ind. Armor";
    }

    public String AbbrevName() {
        return "IN";
    }

    public String MegaMekName( boolean UseRear ) {
        return "Industrial";
    }

    public String BookReference() {
        return "Tech Manual";
    }

    public boolean HasCounterpart() {
        return false;
    }

    public boolean Place( MechArmor a, ifMechLoadout l ) {
        // Industrial armor takes no extra crits.
        return true;
    }

    public boolean Place( MechArmor a, ifMechLoadout l, LocationIndex[] Locs ) {
        // not implemented yet, just place as normal
        return Place( a, l );
    }

    public int NumCrits() {
        return 0;
    }

    public int NumCVSpaces() {
        return 0;
    }

    public int PatchworkCrits() {
        return 0;
    }

    public int PatchworkSpaces() {
        return 0;
    }

    public double GetAVMult() {
        return 0.67;
    }

    public double GetPointsPerTon() {
        return 0.0933;
    }

    public double GetCostMult() {
        return 5000.0;
    }

    public boolean IsStealth() {
        return false;
    }

    public double GetBVTypeMult() {
        return 1.0;
    }

    public int GetBAR() {
        return 10;
    }

    public boolean LocationLocked() {
        return locked;
    }

    public void SetLocked( boolean l ) {
        locked = l;
    }

    public MechModifier GetMechModifier() {
        return null;
    }

    public AvailableCode GetAvailability() {
        return AC;
    }

    public boolean AllowHarJel(){
        return false;
    }
}
