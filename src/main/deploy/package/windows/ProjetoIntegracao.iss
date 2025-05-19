#define MyAppName "ProjetoIntegracao"
#define MyAppVersion "1.2"
#define MyAppPublisher "Victor Hugo"
#define MyAppURL "http://www.projetointegracao.com/"
#define MyAppExeName "ProjetoIntegracao.exe"

[Setup]
AppId={{E7D60282-32DA-4559-B9CC-AE2655D000FD}}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}

DefaultDirName={localappdata}\{#MyAppName}
SetupIconFile=ProjetoIntegracao\ProjetoIntegracao.ico
DisableProgramGroupPage=yes
OutputDir=.
OutputBaseFilename=ProjetoIntegracao-Installer
Compression=lzma
SolidCompression=yes
WizardImageStretch=No
WizardSmallImageFile=ProjetoIntegracao-setup-icon.bmp

[Languages]
Name: "brazilianportuguese"; MessagesFile: "compiler:Languages\BrazilianPortuguese.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "ProjetoIntegracao\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "ProjetoIntegracao\ProjetoIntegracao.exe"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{commonprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: shellexec postinstall skipifsilent
